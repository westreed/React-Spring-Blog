package com.spring.springserver.domain.recommend.entity;

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
            columnNames = {"board_id", "member_id"}
        )
    }
)
public class Recommend {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Recommend(Board board, Member member){
        this.board = board;
        this.member = member;
    }
}
