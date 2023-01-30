package com.spring.springtest.config;

import com.spring.springtest.uility.RSAUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RSAConfig {
    @Bean
    public RSAUtil rsaUtil(){
        return new RSAUtil();
    }
}
