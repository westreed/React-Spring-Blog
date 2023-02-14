package com.spring.springserver.domain.category.repository;

import com.spring.springserver.domain.category.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);
    void saveAll(List<Category> categories);
    Optional<Category> findById(Long id);
    List<Category> findAll();
    Optional<Category> update(Category category);
    void updateAll(List<Category> categories);
    void delete(Category category);
    void deleteAll();
}
