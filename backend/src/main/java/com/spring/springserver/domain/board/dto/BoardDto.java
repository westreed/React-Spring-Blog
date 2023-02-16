package com.spring.springserver.domain.board.dto;

import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class BoardDto {

    // 카테고리, 게시글 조회 등
    @Getter
    @NoArgsConstructor
    public static class Search {
        private Long id;
        private String title;
        private String content;
        private int view;
        private Member member;
        private Category category;
        private Timestamp createData;

        @Builder
        public Search(Long id, String title, String content, int view, Member member, Category category, Timestamp createData){
            this.id = id;
            this.title = title;
            this.content = content;
            this.view = view;
            this.member = member;
            this.category = category;
            this.createData = createData;
        }
    }
}
