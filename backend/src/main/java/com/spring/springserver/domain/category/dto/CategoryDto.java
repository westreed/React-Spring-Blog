package com.spring.springserver.domain.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryDto {

    @Getter
    @NoArgsConstructor
    public static class Data {
        private Long id;
        private int layer;
        private String name;

        @Builder
        public Data(Long id, int layer, String name){
            this.id = id;
            this.layer = layer;
            this.name = name;
        }
    }
}
