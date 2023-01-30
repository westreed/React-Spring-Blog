package com.spring.springtest.uility;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.PrivateKey;

@RestController
public class RSAController {

    @Autowired RSAUtil rsaUtil;

    @GetMapping("/api/key")
    public RSAForm getRSAKEY(HttpSession session){
        // RSA 키 생성
        PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
        if (key != null) { // 기존 키 파기
            session.removeAttribute("RSAprivateKey");
            System.out.println("세션 파기됨");
        }
        RSA rsa = rsaUtil.createRSA();
        RSAForm rsaForm = new RSAForm(rsa.getModulus(), rsa.getExponent());
        System.out.println("rsa생성 : " + rsaForm.getModulus());
        session.setAttribute("RSAprivateKey", rsa.getPrivateKey());
        return rsaForm;
    }

    @Getter
    public class RSAForm {
        private String modulus;
        private String exponent;

        public RSAForm(String modulus, String exponent){
            this.modulus = modulus;
            this.exponent = exponent;
        }
    }

}
