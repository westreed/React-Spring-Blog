package com.spring.springserver.uility;

import lombok.Getter;

import java.security.PrivateKey;

@Getter
public class RSA {
    private PrivateKey privateKey;
    private String modulus;
    private String exponent;

    public RSA(PrivateKey privateKey, String modulus, String exponent) {
        this.privateKey = privateKey;
        this.modulus = modulus;
        this.exponent = exponent;
    }
}