package com.spring.springserver.repository;

import com.spring.springserver.domain.category.entity.Category;
import com.spring.springserver.domain.category.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class JpaCategoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void 카테고리추가(){
        // given
        List<Category> categories = new ArrayList<Category>();
        for (int i=0; i<5; i++){
            Category category = new Category(i, Integer.toString(i) + "번 카테고리");
            categories.add(category);
        }

        categoryRepository.saveAll(categories);

        // when

        // then
    }

    @Test
    public void 카테고리삭제(){
        // given
        // when
        categoryRepository.deleteAll();
        // then
    }
}
