package com.example;

import java.util.Arrays;
import java.util.Scanner;

import com.example.SecureHashing;

import com.example.Database;

public class Helper {

    private static final Scanner sc = new Scanner(System.in);

    public static String insertDots(String str) {
        String number = "";
        for (char c: str.toCharArray()) 
            number += c + ".";

        return number.substring(0, number.length() - 1);
    }

    public static String removeDots(String str) {
        return String.join("", str.split("\\."));
    }

    public static boolean checkPasswordValid(String password) {
        
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
