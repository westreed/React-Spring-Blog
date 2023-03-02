package com.spring.springserver.domain.category.controller;

import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/api/categories")
    public String patchCategories(@RequestBody List<CategoryDto.Data> categories){
        List<Category> categoryList = new ArrayList<>();
        for(CategoryDto.Data category : categories){
            categoryList.add(
                    Category.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .layer(category.getLayer())
                            .build()
            );
        }
        categoryService.updateCategories(categoryList);
        return "success";
    }

    @GetMapping("/api/categories")
    public List<CategoryDto.Data> getCategories(){
        List<CategoryDto.Data> categories = new ArrayList<>();
        for(Category category : categoryService.getCategories()){
            categories.add(new CategoryDto.Data(category));
        }
        return categories;
    }
}
