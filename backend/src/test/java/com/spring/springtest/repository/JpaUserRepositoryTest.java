package com.spring.springtest.repository;

import com.spring.springtest.user.repository.UserRepository;
import com.spring.springtest.user.service.UserService;
import com.spring.springtest.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class JpaUserRepositoryTest {
    @Autowired UserRepository userRepository;
    @Autowired UserService userService;

    @Test
    public void 회원가입(){
        // given

        // when
        userService.join("갈대", "1234", "westreed1@naver.com");

        // then
        Optional<User> result = userRepository.findByEmail("westreed1@naver.com");
        if(result.isPresent()){
            User res = result.get();
            System.out.println("결과 이름:" + res.getUsername());
            System.out.println("결과 비번:" + res.getPassword());
            System.out.println("결과 이메일:" + res.getEmail());
        }
        else throw new IllegalStateException("회원가입에 실패했습니다.");
    }
}
