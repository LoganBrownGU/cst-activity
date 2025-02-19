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

        return bytesToHex(digest.digest(str.getBytes(StandardCharsets.UTF_16)));
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
