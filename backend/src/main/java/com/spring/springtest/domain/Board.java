package com.spring.springtest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

// https://velog.io/@deannn/Spring-Boot-Blog-Project-DB-%ED%85%8C%EC%9D%B4%EB%B8%94-%EB%A7%8C%EB%93%A4%EA%B8%B0

@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Lob
    private String content; // @Lob - 대용량 데이터를 처리하기 위한 어노테이션.

    @ColumnDefault("0")
    private int view;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createData;

}