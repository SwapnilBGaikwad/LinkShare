package com.connect.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
class RandomGenerator {
    private final static String ALL_CHARS = "abcdefghijklmnopqrstuvwxyz1234567890";

    String get() {
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            final int index = random.nextInt(36);
            salt.append(ALL_CHARS.charAt(index));
        }
        return salt.toString();
    }
}
