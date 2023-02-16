package com.spring.springserver.domain.board.controller;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.mapper.BoardMapper;
import com.spring.springserver.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/api/posts/{categoryId}")
    public List<BoardDto.Search> getCategoryPost(@PathVariable Long categoryId){
        BoardMapper mapper = BoardMapper.INSTANCE;
         return mapper.entityToDtoSearch(boardService.getPostCategory(categoryId));
    }

//    @GetMapping("/api/posts")
//    public List<BoardDto.Search> getPostAll(){
//    }
}
