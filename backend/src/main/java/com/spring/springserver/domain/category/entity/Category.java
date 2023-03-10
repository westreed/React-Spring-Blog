package com.spring.springserver.domain.category.entity;

import com.spring.springserver.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int layer;

    @Column(nullable = false)
    private String name;

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    private List<Board> board;

    @CreationTimestamp
    private Timestamp createData;

    @Builder
    public Category(Long id, int layer, String name){
        this.id = id;
        this.layer = layer;
        this.name = name;
    }
}