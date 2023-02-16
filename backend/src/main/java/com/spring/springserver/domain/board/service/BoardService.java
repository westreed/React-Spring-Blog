package com.spring.springserver.domain.board.service;

import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Board> getPostCategory(Long categoryId){
        Optional<Category> res = categoryRepository.findById(categoryId);
        if(res.isPresent()) {
            return boardRepository.findByCategoryId(categoryId);
        }
        throw new IllegalArgumentException("해당 카테고리는 존재하지 않습니다.");
    }
}
