package com.spring.springserver.domain.board.repository;

import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.category.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaBoardRepository implements BoardRepository {

    private final EntityManager entityManager;

    public JpaBoardRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Board save(Board board) {
        entityManager.persist(board);
        return board;
    }

    @Override
    public List<Board> findAll() {
        return entityManager.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = entityManager.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    @Override
    public List<Board> findByCategoryId(Long categoryId) {
        return entityManager.createQuery("select b from Board b where b.category.id = :categoryId", Board.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Board> findByMemberId(Long memberId) {
        return entityManager.createQuery("select b from Board b where b.memberId = :memberId", Board.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public void delete(Board board) {
        if (entityManager.contains(board)) {
            entityManager.remove(board);
        }
        else{
            entityManager.remove(entityManager.merge(board));
        }
    }
}
