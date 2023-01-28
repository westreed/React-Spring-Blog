package com.spring.springtest.user.service;

import com.spring.springtest.domain.User;
import com.spring.springtest.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(String username, String password, String email){
        Optional<User> checkUser = userRepository.findByEmail(email);
        if (checkUser.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
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
}
