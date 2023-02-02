package com.spring.springtest.member.controller;

import lombok.Getter;

@Getter
public class MemberLoginForm {
    private String password;
    private String email;
    private Boolean keep;
}
