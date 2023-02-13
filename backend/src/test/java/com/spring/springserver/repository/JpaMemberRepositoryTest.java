package com.spring.springserver.repository;

import com.spring.springserver.domain.member.repository.MemberRepository;
import com.spring.springserver.domain.member.service.MemberService;
import com.spring.springserver.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class JpaMemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입(){
        // given
        memberService.join("갈대", "1234", "westreed@naver.com");
        // when

        // then
        Optional<Member> result = memberRepository.findByEmail("westreed@naver.com");
        if(result.isPresent()){
            Member res = result.get();
            System.out.println("결과 이름:" + res.getUsername());
            System.out.println("결과 비번:" + res.getPassword());
            System.out.println("결과 이메일:" + res.getEmail());
        }
        else throw new IllegalStateException("회원가입에 실패했습니다.");
    }

    @Test
    public void 로그인(){
        // given
        memberService.join("Test", "1234", "test@naver.com");
        // when
        Member member = memberService.login("test@naver.com", "1234");
        // then
        System.out.println("로그인 " + member);
    }
}
