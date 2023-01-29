package com.spring.springtest.user.service;

import com.spring.springtest.domain.User;
import com.spring.springtest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(String username, String password, String email){

        if (username == null || password == null || email == null){
            throw new IllegalArgumentException("데이터를 전부 기입해야 합니다.");
        }

        Optional<User> checkUser = userRepository.findByEmail(email);
        if (checkUser.isPresent()){
            throw new IllegalStateException("이미 회원가입된 이메일입니다.");
        }

        String encodePassword = passwordEncoder.encode(password);
        User user = User.builder()
            .username(username)
            .password(encodePassword)
            .email(email)
            .build();

        userRepository.save(user);
        return user.getId();
    }

    public boolean login(String email, String password){
        Optional<User> checkUser = userRepository.findByEmail(email);
        if (checkUser.isPresent()){
            User loginUser = checkUser.get();

            System.out.println("요청 : " + password);
            System.out.println("데이터 : " + loginUser.getPassword());

            return passwordEncoder.matches(password, loginUser.getPassword());
        }
        else{
            throw new IllegalStateException("가입되지 않은 이메일입니다.");
        }
    }
}
