package com.spring.springserver.domain.board.dto;

import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.member.dto.MemberDto;
import com.spring.springserver.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

public class BoardDto {

    // 카테고리, 게시글 조회 등
    @Getter
    @NoArgsConstructor
    public static class Search {
        private Long id;
        private String title;
        private int view;
        private MemberDto.Search member;
        private CategoryDto.Search category;
        private Timestamp createData;

        @Builder
        public Search(Long id, String title, int view, MemberDto.Search member, CategoryDto.Search category, Timestamp createData){
            this.id = id;
            this.title = title;
            this.view = view;
            this.member = member;
            this.category = category;
            this.createData = createData;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class RequestData {
        private int page;
        private int pageSize;
        private Long id;

        @Builder
        public RequestData(int page, int pageSize, Long id){
            this.page = page;
            this.pageSize = pageSize;
            this.id = id;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Result {
        private int pageNumber;
        private int pageSize;
        private int totalPages;
        private Long totalCount;
        private List<Search> boards;

        @Builder
        public Result (int pageNumber, int pageSize, int totalPages, Long totalCount, List<Search> boards){
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
            this.totalPages = totalPages;
            this.totalCount = totalCount;
            this.boards = boards;
        }
    }
}
