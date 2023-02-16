package com.spring.springserver.domain.board.repository;

import com.spring.springserver.domain.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    List<Board> findAll();
    Optional<Board> findById(Long id);
    List<Board> findByCategoryId(Long categoryId);
    List<Board> findByMemberId(Long memberId);
    void delete(Board board);
}
