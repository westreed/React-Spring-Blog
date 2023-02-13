package com.spring.springserver.config;

import com.spring.springserver.uility.RSAUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RSAConfig {
    @Bean
    public RSAUtil rsaUtil(){
        return new RSAUtil();
    }
}
