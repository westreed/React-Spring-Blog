package com.spring.springtest.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auth {
    private Long id;
    private String username;
    private String role;

    public Auth(Long id, String username, String role){
        this.id = id;
        this.username = username;
        this.role = role;
    }
}
