package com.spring.springserver.domain.member.dto;

import com.spring.springserver.domain.member.entity.Member;
import lombok.*;

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

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Auth {
        @NotBlank
        private String username;
        @Email
        private String email;
        @NotBlank
        private String role;

        public Auth(Member member){
            this.username = member.getUsername();
            this.email = member.getEmail();
            this.role = member.getRole();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class Login {
        @NotBlank
        private String password;
        @Email
        private String email;
        private Boolean keep;

        @Builder
        public Login(Member member, Boolean keep){
            this.password = member.getPassword();
            this.email = member.getEmail();
            this.keep = keep;
        }

        @Builder
        public Login(String password, String email, Boolean keep){
            this.password = password;
            this.email = email;
            this.keep = keep;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Search {
        private String username;

        public Search (Member member){
            this.username = member.getUsername();
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class UserData {
        private String username;
        private String email;

        public UserData (Member member){
            this.username = member.getUsername();
            this.email = member.getEmail();
        }
    }
}
