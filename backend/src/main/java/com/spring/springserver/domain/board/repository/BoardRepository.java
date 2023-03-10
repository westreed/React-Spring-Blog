package com.spring.springserver.domain.board.repository;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.category.entity.Category;

import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    BoardDto.Result findAll(BoardDto.RequestData req);
    Optional<Board> findById(Long id);
    BoardDto.Result findByCategoryId(BoardDto.RequestData req);
    BoardDto.Result findByMemberId(BoardDto.RequestData req);
    Optional<Board> findOneByCategoryId(Long id);
    void delete(Board board);
    void updateViewCount(Long id);
    void updatePostByEdit(BoardDto.Edit edit, Category category);
}
