package com.spring.springserver.uility.file;

import com.spring.springserver.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class File {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String path;

    @Builder
    public File(Long id, String title, String path){
        this.id = id;
        this.title = title;
        this.path = path;
    }
}
