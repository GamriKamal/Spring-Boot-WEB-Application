package com.app.TheMovie.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodePassword {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Error hashing password.");
        }
    }
}
