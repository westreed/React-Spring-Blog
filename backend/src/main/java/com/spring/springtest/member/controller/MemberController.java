package com.spring.springtest.member.controller;

import com.spring.springtest.domain.Member;
import com.spring.springtest.uility.RSAUtil;
import com.spring.springtest.member.service.MemberService;
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

    @Autowired
    public MemberController(MemberService memberService, RSAUtil rsaUtil) {
        this.memberService = memberService;
        this.rsaUtil = rsaUtil;
    }

    @PostMapping("/api/join")
    public String joinAccount(@RequestBody MemberForm memberForm, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAPrivateKey");
        if (key == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }

        try {
            String username = rsaUtil.getDecryptText(key, memberForm.getUsername());
            String email = rsaUtil.getDecryptText(key, memberForm.getEmail());
            String password = rsaUtil.getDecryptText(key, memberForm.getPassword());
            memberService.join(username, email, password);
            session.removeAttribute("RSAPrivateKey");
            return "redirect:/";
        }
        catch (IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/api/login")
    public MemberAuthForm loginAccount(@RequestBody MemberLoginForm memberLoginForm, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAPrivateKey");
        if (key == null) {
            System.out.println("세션에 비밀키가 없습니다.");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }

        try {
            String email = rsaUtil.getDecryptText(key, memberLoginForm.getEmail());
            String password = rsaUtil.getDecryptText(key, memberLoginForm.getPassword());
            Member member = memberService.login(email, password);
            session.removeAttribute("RSAPrivateKey");

            MemberAuthForm auth = new MemberAuthForm(
                    member.getUsername(),
                    member.getEmail(),
                    member.getRole()
            );
            
            // 로그인 세션 생성
            session.setAttribute("auth", auth);
            session.setAttribute("isAuthenticated", true);
            if(memberLoginForm.getKeep()){
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
    public MemberAuthForm getSession(@SessionAttribute(name="isAuthenticated", required = false) boolean isAuth, HttpSession session){
        if (!isAuth){
            System.out.println("세션 로그인 기록 없음");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "로그인된 기록이 없습니다.");
        }
        return (MemberAuthForm) session.getAttribute("auth");
    }

    @GetMapping("/api/logout")
    public String logoutAccount(@SessionAttribute(name="isAuthenticated", required = false) boolean isAuth, HttpSession session){
        if (isAuth){
            session.invalidate();
        }
        return "success";
    }
}
