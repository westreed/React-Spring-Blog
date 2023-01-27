package com.spring.springtest.domain;

import java.sql.Timestamp;

public class Board {
    private Long id;
    private Category category;
    private String title;
    private String content; // @Lob - 대용량 데이터를 처리하기 위한 어노테이션.
    private int view;
    private User user;
    private Timestamp createData;

}
