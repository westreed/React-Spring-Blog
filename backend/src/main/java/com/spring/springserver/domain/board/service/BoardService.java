package com.spring.springserver.domain.board.service;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import com.spring.springserver.domain.like.entity.Recommend;
import com.spring.springserver.domain.member.dto.MemberDto;
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
    
    public BoardDto.Post getPost(Long id){
        Optional<Board> res = boardRepository.findById(id);
        if(res.isPresent()){
            Board board = res.get();
//            System.out.println("Recommends");
//            for (Recommend recommend : board.getRecommends()){
//                System.out.println(recommend.getMember().toString() + " : " + recommend.getBoard().toString());
//            }
            CategoryDto.Search category = new CategoryDto.Search(board.getCategory().getId(), board.getCategory().getName());
            MemberDto.Search member = new MemberDto.Search(board.getMember().getUsername());
            return BoardDto.Post.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
//                    .recommends(board.getRecommends())
                    .category(category)
                    .member(member)
                    .view(board.getView())
                    .createData(board.getCreateData())
                    .build();
        }
        throw new IllegalArgumentException("해당 게시글은 존재하지 않습니다.");
    }

    public void addViewCount(Long id){
        boardRepository.updateViewCount(id);
    }
}
