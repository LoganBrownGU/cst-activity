package com.example;

import java.util.Scanner;

import com.example.Helper;
import com.example.SecureHashing;

class Main {

    private static void signup() {
        String accountNumber;
        String password;
        do {
            password = Helper.getPassword();
            accountNumber = Database.nextAccountNumber();
        } while (!Database.addUser(accountNumber, SecureHashing.hash(password)));

        System.out.println("Your new account number is: " + accountNumber);
    }

    private static void login() {
        String accountNumber;
        String password;
        String hash;

        do {
            accountNumber = Helper.getAccountNumber();
            password = Helper.getPassword();
            hash = Database.getHash(accountNumber);
        } while (hash == null || !SecureHashing.hash(password).equals(hash));
    }

    public static void main(String[] args) {
        System.out.println("Start");
        Scanner sc = new Scanner(System.in);

        String input = "";
        while (!input.equals("login") && !input.equals("signup")) {
            System.out.print("login or signup?: ");
            input = sc.nextLine();
        }

        if (input.equals("signup")) signup();
        
        login();
        System.out.println("You are logged in");
    }
}