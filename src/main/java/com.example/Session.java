package com.example;

import java.util.Scanner;

import com.example.SecureHashing;

import com.example.Database;

public class Session {

    private static final Scanner sc = new Scanner(System.in);
    private static final SecureHashing hasher = new SecureHashing();

    private static String getPassword() {
        String password = "";
        while (password.length() < 8) {
            System.out.print("Enter password: ");
            password = sc.nextLine();
        }
        return password; 
    }

    private static String getAccountNumber() {
        String accountNumber = "";
        while (accountNumber.isBlank() || !accountNumber.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Enter account number: ");
            accountNumber = sc.nextLine();
        }
        return accountNumber;
    }

    private static boolean login() {
        String accountNumber = getAccountNumber();
        String password = getPassword();
        String hash = Database.getHash(accountNumber);

        return hash != null && hash.equals(hasher.hash(password));
    }

    private static void signup() {
        String accountNumber;
        String password;
        do {
            password = getPassword();
            accountNumber = Database.nextAccountNumber();
        } while (!Database.addUser(accountNumber, hasher.hash(password)));

        System.out.println("Your new account number is: " + accountNumber);
    }

    public static void entry() {
        String input = "";
        while (!input.equals("login") && !input.equals("signup")) {
            System.out.print("login or signup?: ");
            input = sc.nextLine();
        }

        if (input.equals("signup")) signup();
        
        while (!login())
            System.out.print("Account number or password incorrect");

        System.out.println("You are logged in");
    }
}
