package com.spring.springtest.domain.category.eneity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault("0")
    private int layer; // Category sort

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Timestamp createData;

    @Builder
    public Category(String name){
        this.name = name;
    }
}