package com.spring.springserver.domain.recommend.controller;

import com.spring.springserver.domain.recommend.service.RecommendService;
import com.spring.springserver.domain.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecommendController {
    private final RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @PostMapping("/api/like/{boardId}")
    public String addPostLike(@PathVariable("boardId") Long boardId, @SessionAttribute(name="auth", required = false) MemberDto.Auth auth){
        recommendService.clickLike(boardId, auth);
        return "success";
    }

    @DeleteMapping("/api/like/{boardId}")
    public String cancelPostLike(@PathVariable("boardId") Long boardId, @SessionAttribute(name="auth", required = false) MemberDto.Auth auth){
        recommendService.cancelLike(boardId, auth);
        return "success";
    }
}
