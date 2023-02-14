package com.spring.springserver.domain.category.service;


import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void updateCategories(List<Category> categories){
        List<Category> prevCategories = categoryRepository.findAll();
        for (Category category : categories){
            categoryRepository.update(category).ifPresent(prevCategories::remove);
        }
        if(prevCategories.size() == 0) return;
        for (Category category : prevCategories){
            categoryRepository.delete(category);
        }
    }
}
