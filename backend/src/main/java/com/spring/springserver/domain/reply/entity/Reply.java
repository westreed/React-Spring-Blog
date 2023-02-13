package com.spring.springserver.domain.reply.entity;

import com.spring.springserver.domain.board.entity.Board;
import com.spring.springserver.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Reply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long replyId;

    @Lob
    private String content; // CKEditor5

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board; // ManyToOne

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member member; // ManyToOne

    @ColumnDefault("0")
    private int likes;

    @CreationTimestamp
    private Timestamp createData; // 순서보장용

    @Builder
    public Reply(Long replyId, String content, Board board, Member member){
        this.replyId = replyId;
        this.content = content;
        this.board = board;
        this.member = member;
    }
}
