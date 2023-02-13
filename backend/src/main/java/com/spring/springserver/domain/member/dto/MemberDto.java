package com.spring.springserver.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {

    @Getter
    public static class Patch {
        private String username;
        private String password;
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public static class AuthInfo {
        private String username;
        private String email;
        private String role;
    }

    @Getter
    public static class Login {
        private String password;
        private String email;
        private Boolean keep;
    }
}
