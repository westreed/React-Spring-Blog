package com.spring.springserver.domain.board.controller;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/api/posts")
    public BoardDto.Result getCategoryPost(@RequestParam int page, @RequestParam int pageSize, @RequestParam(required = false) Long id){
        BoardDto.RequestData req = BoardDto.RequestData.builder()
                .page(page)
                .pageSize(pageSize)
                .id(id)
                .build();
        if(id != null){return boardService.getPostCategory(req);}
        return boardService.getPostAll(req);
    }

//    @GetMapping("/api/posts")
//    public List<BoardDto.Search> getPostAll(){
//    }
}
