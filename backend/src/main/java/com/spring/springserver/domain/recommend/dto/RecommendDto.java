package com.spring.springserver.domain.recommend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RecommendDto {
    @Setter
    @Getter
    @NoArgsConstructor
    public static class id {
        private Long id;
        public id(Long id){
            this.id = id;
        }
    }
}
