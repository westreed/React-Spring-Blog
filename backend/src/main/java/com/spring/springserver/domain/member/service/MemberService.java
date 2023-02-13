package com.spring.springserver.domain.member.service;

import com.spring.springserver.domain.member.entity.Member;
import com.spring.springserver.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(String username, String password, String email){

        if (username == null || password == null || email == null){
            throw new IllegalArgumentException("데이터를 전부 기입해야 합니다.");
        }

        Optional<Member> checkUser = memberRepository.findByEmail(email);
        if (checkUser.isPresent()){
            throw new IllegalStateException("이미 회원가입된 이메일입니다.");
        }

        String encodePassword = passwordEncoder.encode(password);
        Member member = Member.builder()
            .username(username)
            .password(encodePassword)
            .email(email)
            .build();

        memberRepository.save(member);
    }

    public Member login(String email, String password){
        Optional<Member> checkMember = memberRepository.findByEmail(email);
        if (checkMember.isPresent()){
            Member loginMember = checkMember.get();

            System.out.println("요청 : " + password);
            System.out.println("데이터 : " + loginMember.getPassword());

            if(passwordEncoder.matches(password, loginMember.getPassword())){
                return loginMember;
            }
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        throw new IllegalStateException("가입되지 않은 이메일입니다.");
    }
}
