package com.spring.springtest.user.controller;

import com.spring.springtest.uility.RSAUtil;
import com.spring.springtest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import java.security.PrivateKey;

@RestController
public class UserController {

    private UserService userService;
    private RSAUtil rsaUtil;

    @Autowired
    public UserController(UserService userService, RSAUtil rsaUtil) {
        this.userService = userService;
        this.rsaUtil = rsaUtil;
    }

    @PostMapping("/api/join")
    public String joinAccount(@RequestBody UserForm userForm, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
        if (key == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }
        session.removeAttribute("RSAprivateKey");

        try {
            String username = rsaUtil.getDecryptText(key, userForm.getUsername());
            String email = rsaUtil.getDecryptText(key, userForm.getEmail());
            String password = rsaUtil.getDecryptText(key, userForm.getPassword());
            userService.join(username, email, password);
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
    public Boolean loginAccount(@RequestBody UserLoginForm userLoginForm, HttpSession session){
        // 개인키 취득
        PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
        if (key == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비정상 적인 접근 입니다.");
        }
        session.removeAttribute("RSAprivateKey");

        try {
            String email = rsaUtil.getDecryptText(key, userLoginForm.getEmail());
            String password = rsaUtil.getDecryptText(key, userLoginForm.getPassword());
            System.out.println("email : " + email);
            System.out.println("password : " + password);
            return userService.login(email, password);
        }
        catch (IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
