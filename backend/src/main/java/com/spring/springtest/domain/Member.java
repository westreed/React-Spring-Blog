package com.spring.springtest.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

//@Builder
//@AllArgsConstructor
@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Setter
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role;

    @CreationTimestamp
    private Timestamp createData;

    @Builder
    public User (String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
