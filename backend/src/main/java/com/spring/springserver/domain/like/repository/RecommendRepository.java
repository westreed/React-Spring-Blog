package com.spring.springserver.domain.like.repository;

import com.spring.springserver.domain.like.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    @Modifying
    @Query(value = "INSERT INTO recommend (board_id, member_id) VALUES (:boardId, :memberId)", nativeQuery = true)
    int addLike(Long boardId, Long memberId);

    @Modifying
    @Query(value = "DELETE FROM recommend WHERE board_id = :boardId AND member_id = :memberId", nativeQuery = true)
    int removeLike(Long boardId, Long memberId);
}