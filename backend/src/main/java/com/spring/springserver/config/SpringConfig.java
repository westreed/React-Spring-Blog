package com.spring.springserver.config;

import com.spring.springserver.domain.board.repository.BoardRepository;
import com.spring.springserver.domain.board.repository.JpaBoardRepository;
import com.spring.springserver.domain.board.service.BoardService;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import com.spring.springserver.domain.category.repository.JpaCategoryRepository;
import com.spring.springserver.domain.category.service.CategoryService;
import com.spring.springserver.domain.member.service.MemberService;
import com.spring.springserver.domain.member.repository.JpaMemberRepository;
import com.spring.springserver.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager entityManager;

    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(entityManager);
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public CategoryRepository categoryRepository(){
        return new JpaCategoryRepository(entityManager);
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryService(categoryRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(entityManager);
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository(), categoryRepository());
    }
}
