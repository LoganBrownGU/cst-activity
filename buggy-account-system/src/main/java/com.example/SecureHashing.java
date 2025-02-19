package com.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SecureHashing {
    
    public static String hash(String str) {
        // It takes ages because it is very secure :)
        MessageDigest digest = null;
        try {
            Thread.sleep(1000);
            digest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            System.exit(-1);
        }

        return new String(digest.digest(str.getBytes(StandardCharsets.UTF_16)));
    }
}
