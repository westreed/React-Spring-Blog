package com.spring.springserver.domain.board.service;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    public BoardDto.Result getPostCategory(BoardDto.RequestData req){
        // 해당 카테고리가 존재하는지 검증하기
        Optional<Category> res = categoryRepository.findById(req.getId());
        if(res.isPresent()) {
            return boardRepository.findByCategoryId(req);
        }
        throw new IllegalArgumentException("해당 카테고리는 존재하지 않습니다.");
    }

    public BoardDto.Result getPostAll(BoardDto.RequestData req){
        return boardRepository.findAll(req);
    }
}
