package com.spring.springserver.domain.recommend.repository;

import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.member.entity.Member;
import com.spring.springserver.domain.recommend.dto.RecommendDto;
import com.spring.springserver.domain.recommend.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    @Modifying
    @Query(value = "INSERT INTO recommend (board_id, member_id) VALUES (:boardId, :memberId)", nativeQuery = true)
    void addLike(Board boardId, Member memberId);

    @Modifying
    @Query(value = "DELETE FROM recommend WHERE board_id = :boardId AND member_id = :memberId", nativeQuery = true)
    void removeLike(Board boardId, Member memberId);

    @Query(value = "SELECT * FROM recommend WHERE board_id = :boardId", nativeQuery = true)
    List<Recommend> findAllByBoard(Long boardId);
}