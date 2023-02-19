package com.spring.springserver.domain.member.controller;

import com.spring.springserver.domain.member.dto.MemberDto;
import com.spring.springserver.domain.member.entity.Member;
import com.spring.springserver.domain.member.service.MemberService;
import com.spring.springserver.uility.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import java.security.PrivateKey;

@RestController
public class MemberController {

    private final MemberService memberService;
    private final RSAUtil rsaUtil;
    private final MemberDto.Auth nullAuth;

    @Autowired
    public MemberController(MemberService memberService, RSAUtil rsaUtil) {
        this.memberService = memberService;
        this.rsaUtil = rsaUtil;

        this.nullAuth = new MemberDto.Auth(null, null, null);
    }

    @PostMapping("/api/join")
    public String joinAccount(@RequestBody MemberDto.Patch patchRequest, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAPrivateKey");
        if (key == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }

        try {
            String username = rsaUtil.getDecryptText(key, patchRequest.getUsername());
            String email = rsaUtil.getDecryptText(key, patchRequest.getEmail());
            String password = rsaUtil.getDecryptText(key, patchRequest.getPassword());
            memberService.join(username, email, password);
            session.removeAttribute("RSAPrivateKey");
            return "success";
        }
        catch (IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/api/login")
    public MemberDto.Auth loginAccount(@RequestBody MemberDto.Login loginRequest, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAPrivateKey");
        if (key == null) {
            System.out.println("세션에 비밀키가 없습니다.");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }

        try {
            String email = rsaUtil.getDecryptText(key, loginRequest.getEmail());
            String password = rsaUtil.getDecryptText(key, loginRequest.getPassword());
            Member member = memberService.login(email, password);
            session.removeAttribute("RSAPrivateKey");

            MemberDto.Auth auth = new MemberDto.Auth(
                    member.getUsername(),
                    member.getEmail(),
                    member.getRole()
            );
            
            // 로그인 세션 생성
            session.setAttribute("auth", auth);
            session.setAttribute("isAuthenticated", true);
            if(loginRequest.getKeep()){
                System.out.println("로그인 상태 유지 체크됨");
            }
            return auth;
        }
        catch (IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/api/session")
    public MemberDto.Auth getSession(@SessionAttribute(name="isAuthenticated", required = false) boolean isAuth, HttpSession session){
        if (!isAuth){
            System.out.println("세션 로그인 기록 없음");
            return this.nullAuth;
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "로그인된 기록이 없습니다.");
        }
//        System.out.println("세션 " + session.getMaxInactiveInterval());
//        session.setMaxInactiveInterval(60*30); // 세션 시간 갱신
        return (MemberDto.Auth) session.getAttribute("auth");
    }

    @GetMapping("/api/logout")
    public String logoutAccount(@SessionAttribute(name="isAuthenticated", required = false) boolean isAuth, HttpSession session){
        if (isAuth){
            session.invalidate();
        }
        return "success";
    }
}
