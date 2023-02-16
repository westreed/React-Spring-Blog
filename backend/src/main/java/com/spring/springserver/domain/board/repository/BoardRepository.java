package com.spring.springserver.domain.board.repository;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    BoardDto.Result findAll(BoardDto.RequestData req);
    Optional<Board> findById(Long id);
    BoardDto.Result findByCategoryId(BoardDto.RequestData req);
    BoardDto.Result findByMemberId(BoardDto.RequestData req);
    void delete(Board board);
}
