package com.spring.springserver.domain.recommend.service;

import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.recommend.dto.RecommendDto;
import com.spring.springserver.domain.recommend.entity.Recommend;
import com.spring.springserver.domain.recommend.repository.RecommendRepository;
import com.spring.springserver.domain.member.dto.MemberDto;
import com.spring.springserver.domain.member.entity.Member;
import com.spring.springserver.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecommendService {
    @Autowired RecommendRepository recommendRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired BoardRepository boardRepository;

    public void clickLike(Long boardId, MemberDto.Auth auth){
        if(auth == null){ throw new IllegalArgumentException("로그인 정보가 없습니다."); }
        memberRepository.findByEmail(auth.getEmail()).ifPresent(member -> {
            boardRepository.findById(boardId).ifPresent(board -> {
                recommendRepository.addLike(board, member);
            });
        });
    }

    public void cancelLike(Long boardId, MemberDto.Auth auth){
        if(auth == null){ throw new IllegalArgumentException("로그인 정보가 없습니다."); }
        memberRepository.findByEmail(auth.getEmail()).ifPresent(member -> {
            boardRepository.findById(boardId).ifPresent(board -> {
                 recommendRepository.removeLike(board, member);
            });
        });
    }

    public List<RecommendDto.Request> findBoardRecommend(Long id){
        List<RecommendDto.Request> requests = new ArrayList<>();
        for(Recommend recommend : recommendRepository.findAllByBoard(id)){
            requests.add(RecommendDto.Request.builder()
                    .id(recommend.getId())
                    .member(recommend.getMember())
                    .board(recommend.getBoard())
                    .build());
        }
        return requests;
    }
}
