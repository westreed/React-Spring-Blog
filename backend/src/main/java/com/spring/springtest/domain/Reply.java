package com.spring.springtest.domain;

import java.sql.Timestamp;

public class Reply {
    private Long id;
    private Long replyId;
    private String content; // CKEditor5
    private Board board; // ManyToOne
    private User user; // ManyToOne
    private int like;
    private Timestamp createData; // 순서보장용
}
