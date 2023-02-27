package com.spring.springserver.domain.like.entity;

import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.member.entity.Member;
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

    @JoinColumn(name = "boardId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @JoinColumn(name = "memberId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Recommend(Board board, Member member){
        this.board = board;
        this.member = member;
    }
}
