package com.spring.springserver.domain.category.controller;

import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.mapper.CategoryMapper;
import com.spring.springserver.domain.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        CategoryMapper mapper = CategoryMapper.INSTANCE;
        categoryService.updateCategories(mapper.dtoToEntity(categories));
        return "success";
    }

    @GetMapping("/api/categories")
    public List<CategoryDto.Data> getCategories(){
        CategoryMapper mapper = CategoryMapper.INSTANCE;
        return mapper.entityToDto(categoryService.getCategories());
    }
}
