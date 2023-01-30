package com.spring.springtest.member.controller;

import com.spring.springtest.domain.Member;
import com.spring.springtest.uility.RSAUtil;
import com.spring.springtest.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
        session.removeAttribute("RSAPrivateKey");

        try {
            String username = rsaUtil.getDecryptText(key, memberForm.getUsername());
            String email = rsaUtil.getDecryptText(key, memberForm.getEmail());
            String password = rsaUtil.getDecryptText(key, memberForm.getPassword());
            memberService.join(username, email, password);
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
    public String loginAccount(@RequestBody MemberLoginForm memberLoginForm, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAPrivateKey");
        if (key == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }
        session.removeAttribute("RSAPrivateKey");

        try {
            String email = rsaUtil.getDecryptText(key, memberLoginForm.getEmail());
            String password = rsaUtil.getDecryptText(key, memberLoginForm.getPassword());
            System.out.println("email : " + email);
            System.out.println("password : " + password);
            Member member = memberService.login(email, password);
            session.setAttribute("userInfo", member);
            System.out.println("세션id : " + session.getId() + " 내용 : " + session.getAttribute("userInfo"));
            return session.getId();
        }
        catch (IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
