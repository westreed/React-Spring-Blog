package com.spring.springserver.domain.board.dto;

import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.recommend.dto.RecommendDto;
import com.spring.springserver.domain.member.dto.MemberDto;
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
        public Search(Board board){
            this.id = board.getId();
            this.title = board.getTitle();
            this.view = board.getView();
            this.member = new MemberDto.Search(board.getMember());
            this.category = new CategoryDto.Search(board.getCategory());
            this.createData = board.getCreateData();
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
        private Long id;
        private int pageNumber;
        private int pageSize;
        private int totalPages;
        private Long totalCount;
        private List<Search> boards;

        @Builder
        public Result (Long id, int pageNumber, int pageSize, int totalPages, Long totalCount, List<Search> boards){
            this.id = id;
            this.pageNumber = pageNumber;
            this.pageSize = pageSize;
            this.totalPages = totalPages;
            this.totalCount = totalCount;
            this.boards = boards;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Post {
        private Long id;
        private String title;
        private String content;
        private int view;
        private List<RecommendDto.RecommendUser> recommends;
        private MemberDto.Search member;
        private CategoryDto.Search category;
        private boolean likeState;
        private int likeCount;
//        private List<Reply> reply;
        private Timestamp createData;

        @Builder
        public Post (Board board, List<RecommendDto.RecommendUser> recommends, MemberDto.Search member, CategoryDto.Search category, boolean likeState, int likeCount){
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.view = board.getView();
            this.createData = board.getCreateData();
            this.recommends = recommends;
            this.member = member;
            this.category = category;
            this.likeState = likeState;
            this.likeCount = likeCount;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class id {
        private Long id;

        public id(Long id){
            this.id = id;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Write {
        private String title;
        private String content;
        private String email;
        private Long category;

        @Builder
        public Write(String title, String content, String email, Long category){
            this.title = title;
            this.content = content;
            this.email = email;
            this.category = category;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Edit {
        private Long id;
        private String title;
        private String content;
        private String email;
        private Long category;

        @Builder
        public Edit(Long id, String title, String content, String email, Long category){
            this.id = id;
            this.title = title;
            this.content = content;
            this.email = email;
            this.category = category;
        }
    }
}
