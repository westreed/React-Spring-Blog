package com.spring.springserver.domain.board.controller;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/api/posts")
    public BoardDto.Result getCategoryPost(@RequestParam int page, @RequestParam int pageSize, @RequestParam Long id){
        BoardDto.RequestData req = BoardDto.RequestData.builder()
                .page(page)
                .pageSize(pageSize)
                .id(id)
                .build();
        if(id > 0){return boardService.getPostCategory(req);}
        return boardService.getPostAll(req);
    }

    @GetMapping("/api/post")
    public BoardDto.Post getPost(@RequestParam Long id){
        return boardService.getPost(id);
    }

    @PutMapping("/api/post")
    public String addView(@RequestBody BoardDto.id id){
        boardService.addViewCount(id.getId());
        return "success";
    }
}
