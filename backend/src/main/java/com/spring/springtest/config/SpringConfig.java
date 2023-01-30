package com.spring.springtest.config;

import com.spring.springtest.member.service.MemberService;
import com.spring.springtest.member.repository.JpaMemberRepository;
import com.spring.springtest.member.repository.MemberRepository;
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
