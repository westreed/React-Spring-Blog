package com.spring.springserver.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {

    @Getter
    public static class Patch {
        @NotBlank(message = "회원 이름은 공백이 아니어야 합니다.")
        @Pattern(regexp = "^[A-Za-z0-9]{1,30}$", message = "닉네임은 영어와 숫자만 사용할 수 있습니다.")
        private String username;
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$", message = "비밀번호는 8글자이상 20글자 이하로 영어,숫자,특수문자가 1개이상 들어가야 합니다.")
        private String password;
        @Email
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public static class AuthInfo {
        @NotBlank
        private String username;
        @Email
        private String email;
        @NotBlank
        private String role;
    }

    @Getter
    public static class Login {
        @NotBlank
        private String password;
        @Email
        private String email;
        private Boolean keep;
    }
}
