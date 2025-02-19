package com.example;

import java.util.Scanner;

import com.example.SecureHashing;

import com.example.Database;

public class Helper {

    private static final Scanner sc = new Scanner(System.in);
    private static final SecureHashing hasher = new SecureHashing();

    public static boolean checkPasswordValid(String password) {
        if (password.length() < 8) return false;
        
        boolean containsSpecial = false;
        for (char c: password.toCharArray())
            if (!Character.isAlphabetic(c) && !Character.isDigit(c)) containsSpecial = true;
        if (!containsSpecial) return false;

        return true;
    }

    public static String getPassword() {
        String password = "";
        while (!checkPasswordValid(password)) {
            System.out.print("Enter password: ");
            password = sc.nextLine();
        }
        return password; 
    }

    public static String getAccountNumber() {
        String accountNumber = "";
        while (accountNumber.isBlank() || !accountNumber.matches("-?\\d+(\\.\\d+)?")) {
            System.out.print("Enter account number: ");
            accountNumber = sc.nextLine();
        }
        return accountNumber;
    }
    
}
