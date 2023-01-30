package com.spring.springtest.config;

import com.spring.springtest.user.service.UserService;
import com.spring.springtest.user.repository.JpaUserRepository;
import com.spring.springtest.user.repository.UserRepository;
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
    public UserRepository userRepository(){
        return new JpaUserRepository(entityManager);
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
}
