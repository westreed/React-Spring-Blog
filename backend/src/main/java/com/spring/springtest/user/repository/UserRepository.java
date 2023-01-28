package com.spring.springtest.user.repository;

import com.spring.springtest.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User> findAll();
    User delete(User user);
    Optional<User> deleteById(Long id);
    Optional<User> findByEmail(String email);
}
