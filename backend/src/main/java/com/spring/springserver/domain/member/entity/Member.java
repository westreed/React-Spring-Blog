package com.spring.springserver.domain.member.entity;

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
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 30)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Setter
    @ColumnDefault("'user'")
    private String role;

    @CreationTimestamp
    private Timestamp createData;

    @Builder
    public Member(String username, String password, String email, String role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
