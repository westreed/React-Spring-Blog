package com.spring.springserver.domain.board.service;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import com.spring.springserver.domain.member.repository.MemberRepository;
import com.spring.springserver.domain.recommend.dto.RecommendDto;
import com.spring.springserver.domain.recommend.entity.Recommend;
import com.spring.springserver.domain.recommend.service.RecommendService;
import com.spring.springserver.domain.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    @Autowired RecommendService recommendService;
    @Autowired MemberRepository memberRepository;

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
    
    public BoardDto.Post getPost(Long id, MemberDto.Auth auth){
        Optional<Board> res = boardRepository.findById(id);
        if(res.isPresent()){
            Board board = res.get();
            AtomicReference<Long> memberId = new AtomicReference<>(0L);
            if (auth != null) { // 세션 정보가 있을 때
                memberRepository.findByEmail(auth.getEmail()).ifPresent(member -> memberId.set(member.getId()));
            }

            boolean likeState = false;

            List<RecommendDto.Request> recommends = recommendService.findBoardRecommend(board.getId());
            List<RecommendDto.RecommendUser> recommendList = new ArrayList<>();
            for (RecommendDto.Request recommend : recommends) {
                if (Objects.equals(recommend.getMember().getId(), memberId.get())) { likeState = true; }
                recommendList.add(new RecommendDto.RecommendUser(recommend.getId(), recommend.getMember().getUsername()));
            }
            return BoardDto.Post.builder()
                    .board(board)
                    .recommends(recommendList)
                    .likeState(likeState)
                    .likeCount(recommends.size())
                    .category(new CategoryDto.Search(board.getCategory()))
                    .member(new MemberDto.Search(board.getMember()))
                    .build();
        }
        throw new IllegalArgumentException("해당 게시글은 존재하지 않습니다.");
    }

    public void addViewCount(Long id){
        boardRepository.updateViewCount(id);
    }
}
