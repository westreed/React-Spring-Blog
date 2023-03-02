package com.spring.springserver.domain.category.dto;

import com.spring.springserver.domain.category.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CategoryDto {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Data {
        private Long id;
        private int layer;
        private String name;

        public Data(Category category){
            this.id = category.getId();
            this.layer = category.getLayer();
            this.name = category.getName();
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Search {
        private Long id;
        private String name;

        public Search(Category category){
            this.id = category.getId();
            this.name = category.getName();
        }
    }
}
