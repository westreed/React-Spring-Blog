package com.spring.springtest.member.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberAuthForm {
    private String username;
    private String email;
    private String role;

    public MemberAuthForm(String username, String email, String role){
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
