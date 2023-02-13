package com.spring.springserver.config;

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
    public MemberRepository userRepository(){
        return new JpaMemberRepository(entityManager);
    }

    @Bean
    public MemberService userService(){
        return new MemberService(userRepository());
    }
}
