package com.spring.springtest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Entity
public class Reply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    private Long replyId;

    @Lob
    private String content; // CKEditor5

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board; // ManyToOne

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user; // ManyToOne

    @ColumnDefault("0")
    private int likes;

    @CreationTimestamp
    private Timestamp createData; // 순서보장용
}
