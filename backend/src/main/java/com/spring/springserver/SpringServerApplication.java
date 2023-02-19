package com.spring.springserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringServerApplication {

	public SpringServerApplication(@Value("${variable.url}") String url) {
		System.out.println("환경변수 설정 : " + url);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringServerApplication.class, args);
	}

}
