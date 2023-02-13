package com.spring.springserver.domain.member.dto;

import lombok.Getter;

@Getter
public class MemberLoginDto {
    private String password;
    private String email;
    private Boolean keep;
}
