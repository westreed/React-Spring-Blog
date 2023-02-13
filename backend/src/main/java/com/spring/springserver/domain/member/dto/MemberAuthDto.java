package com.spring.springserver.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberAuthDto {
    private String username;
    private String email;
    private String role;

    public MemberAuthDto(String username, String email, String role){
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
