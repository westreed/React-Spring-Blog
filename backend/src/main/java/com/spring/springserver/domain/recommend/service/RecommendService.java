package com.spring.springserver.domain.recommend.service;

import com.spring.springserver.domain.recommend.entity.Recommend;
import com.spring.springserver.domain.recommend.repository.RecommendRepository;
import com.spring.springserver.domain.member.dto.MemberDto;
import com.spring.springserver.domain.member.entity.Member;
import com.spring.springserver.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RecommendService {
    @Autowired private RecommendRepository recommendRepository;
    @Autowired private MemberRepository memberRepository;

    public int clickLike(Long boardId, MemberDto.Auth auth){
        if(auth == null){
            throw new IllegalArgumentException("로그인 정보가 없습니다.");
        }
        Optional<Member> member = memberRepository.findByEmail(auth.getEmail());
        if(member.isEmpty()){
            throw new IllegalArgumentException("없는 유저입니다.");
        }
        return recommendRepository.addLike(boardId, member.get().getId());
    }

    public int cancelLike(Long boardId, MemberDto.Auth auth){
        if(auth == null){
            throw new IllegalArgumentException("로그인 정보가 없습니다.");
        }
        Optional<Member> member = memberRepository.findByEmail(auth.getEmail());
        if(member.isEmpty()){
            throw new IllegalArgumentException("없는 유저입니다.");
        }
        return recommendRepository.removeLike(boardId, member.get().getId());
    }

    public List<Recommend> findBoardRecommend(Long id){
        return recommendRepository.findAllByBoard(id);
    }
}
