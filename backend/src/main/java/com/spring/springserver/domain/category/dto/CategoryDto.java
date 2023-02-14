package com.spring.springserver.domain.category.dto;

import lombok.Builder;
import lombok.Getter;

public class CategoryDto {

    @Getter
    public static class Data {
        private int layer;
        private String name;

        @Builder
        public Data(int layer, String name){
            this.layer = layer;
            this.name = name;
        }
    }
}
