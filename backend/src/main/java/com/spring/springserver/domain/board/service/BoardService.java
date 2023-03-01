package com.spring.springserver.domain.board.service;

import com.spring.springserver.domain.board.dto.BoardDto;
import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import com.spring.springserver.domain.member.entity.Member;
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

public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    @Autowired private RecommendService recommendService;
    @Autowired private MemberRepository memberRepository;

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
            Long memberId = 0L;
            if (auth != null) {
                Optional<Member> member = memberRepository.findByEmail(auth.getEmail());
                if (member.isPresent()) {
                    memberId = member.get().getId();
                }
            }
            List<Recommend> recommends = recommendService.findBoardRecommend(board.getId());
            List<RecommendDto.id> recommendList = new ArrayList<>();
            boolean likeState = false;
            for (Recommend recommend : recommends) {
                if (Objects.equals(recommend.getMemberId(), memberId)) {
                    likeState = true;
                }
                recommendList.add(new RecommendDto.id(recommend.getId()));

            }
            return BoardDto.Post.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .recommends(recommendList)
                    .likeState(likeState)
                    .likeCount(recommends.size())
                    .category(new CategoryDto.Search(board.getCategory().getId(), board.getCategory().getName()))
                    .member(new MemberDto.Search(board.getMember().getUsername()))
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
