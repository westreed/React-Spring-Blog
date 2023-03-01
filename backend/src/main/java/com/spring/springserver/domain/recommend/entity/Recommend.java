package com.spring.springserver.domain.recommend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name = "recommend_uk",
            columnNames = {"boardId", "memberId"}
        )
    }
)
public class Recommend {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long boardId;
    private Long memberId;

    @Builder
    public Recommend(Long boardId, Long memberId){
        this.boardId = boardId;
        this.memberId = memberId;
    }
}
