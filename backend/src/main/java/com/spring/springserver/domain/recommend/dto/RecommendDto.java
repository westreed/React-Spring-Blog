package com.spring.springserver.domain.recommend.dto;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.member.dto.MemberDto;
import com.spring.springserver.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RecommendDto {
    @Setter
    @Getter
    @NoArgsConstructor
    public static class RecommendUser {
        private Long id;
        private String username;
        public RecommendUser(Long id, String username){
            this.id = id;
            this.username = username;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Request {
        private Long id;
        private Member member;
        private Long boardId;

        @Builder
        public Request (Long id, Member member, Board board){
            this.id = id;
            this.member = member;
            this.boardId = board.getId();
        }
    }
}
