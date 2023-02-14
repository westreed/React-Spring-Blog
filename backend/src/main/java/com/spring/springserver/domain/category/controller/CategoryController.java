package com.spring.springserver.domain.category.controller;

import com.spring.springserver.domain.category.dto.CategoryDto;
import com.spring.springserver.domain.category.mapper.CategoryMapper;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/api/categories")
    public String patchCategories(@RequestBody List<CategoryDto.Data> categories){
        for(CategoryDto.Data category : categories) {
            System.out.println(category);
        }
        return "success";
    }

    @GetMapping("/api/categories")
    public List<CategoryDto.Data> getCategories(){
        // TODO: https://huisam.tistory.com/entry/mapStruct 맵핑 작업 하기

        CategoryMapper mapper = CategoryMapper.INSTANCE;
        return mapper.entityToDto(categoryRepository.findAll());
    }
}
