package com.qpassessment.qpgrocery.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptHashEncoder {
    public static void main(String[] args) {
        String password = "root";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); 
        String hash = encoder.encode(password);
        System.out.println("BCrypt Hash: " + hash);
    }
}

