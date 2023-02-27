package com.spring.springserver.domain.board.repository;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.board.mapper.BoardMapper;
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
    public BoardDto.Result findAll(BoardDto.RequestData req) {
        Long totalCount = entityManager.createQuery("select count(b) from Board b", Long.class)
                .getSingleResult();
        int totalPages = (int) (totalCount / req.getPageSize()) + ((totalCount % req.getPageSize()) > 0 ? 1 : 0);
        List<Board> boards = entityManager.createQuery("select b from Board b order by b.createData desc", Board.class)
                .setFirstResult(req.getPage() * req.getPageSize())
                .setMaxResults(req.getPageSize())
                .getResultList();

        BoardMapper mapper = BoardMapper.INSTANCE;
        return BoardDto.Result.builder()
                .id(req.getId())
                .totalPages(totalPages)
                .totalCount(totalCount)
                .pageNumber(req.getPage())
                .pageSize(req.getPageSize())
                .boards(mapper.entityToDtoSearch(boards))
                .build();
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = entityManager.createQuery("select b from Board b where b.id = :id", Board.class)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.ofNullable(board);
    }

    @Override
    public BoardDto.Result findByCategoryId(BoardDto.RequestData req) {
        Long totalCount = entityManager.createQuery("select count(b) from Board b where b.category.id = :id", Long.class)
                .setParameter("id", req.getId())
                .getSingleResult();
        int totalPages = (int) (totalCount / req.getPageSize()) + ((totalCount % req.getPageSize()) > 0 ? 1 : 0);
        List<Board> boards = entityManager.createQuery("select b from Board b where b.category.id = :id order by b.createData desc", Board.class)
                .setParameter("id", req.getId())
                .setFirstResult(req.getPage() * req.getPageSize())
                .setMaxResults(req.getPageSize())
                .getResultList();

        BoardMapper mapper = BoardMapper.INSTANCE;
        return BoardDto.Result.builder()
                .id(req.getId())
                .id(req.getId())
                .totalPages(totalPages)
                .totalCount(totalCount)
                .pageNumber(req.getPage())
                .pageSize(req.getPageSize())
                .boards(mapper.entityToDtoSearch(boards))
                .build();
    }

    @Override
    public BoardDto.Result findByMemberId(BoardDto.RequestData req) {
        Long totalCount = entityManager.createQuery("select count(b) from Board b where b.member.id = :id", Long.class)
                .setParameter("id", req.getId())
                .getSingleResult();
        int totalPages = (int) (totalCount / req.getPageSize()) + ((totalCount % req.getPageSize()) > 0 ? 1 : 0);
        List<Board> boards = entityManager.createQuery("select b from Board b where b.member.id = :id order by b.createData desc", Board.class)
                .setParameter("id", req.getId())
                .setFirstResult(req.getPage() * req.getPageSize())
                .setMaxResults(req.getPageSize())
                .getResultList();

        BoardMapper mapper = BoardMapper.INSTANCE;
        return BoardDto.Result.builder()
                .totalPages(totalPages)
                .totalCount(totalCount)
                .pageNumber(req.getPage())
                .pageSize(req.getPageSize())
                .boards(mapper.entityToDtoSearch(boards))
                .build();
    }

    @Override
    public Optional<Board> findOneByCategoryId(Long id) {
        List<Board> result = entityManager.createQuery("select b from Board b where b.category.id = :id", Board.class)
                .setParameter("id", id)
                .getResultList();

        return result.stream().findAny();
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

    @Override
    public void updateViewCount(Long id) {
        Board board = entityManager.find(Board.class, id);
        board.setView(board.getView()+1);
        entityManager.flush();
    }
}
