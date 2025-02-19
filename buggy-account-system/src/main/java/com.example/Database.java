package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

public class Database {
    
    private static boolean writeToFile(String textToWrite) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("database.csv"));
            PrintWriter pw = new PrintWriter(bw);
            pw.println(textToWrite);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private static HashMap<String, String> readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data_base.csv"))) {
            
            HashMap<String, String> map = new HashMap<>();
            while (reader.ready()) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                map.put(parts[0], parts[1]);
            }

            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean addUser(String accountNumber, String passwordHash) {
        String line = accountNumber + "-" + passwordHash;
        writeToFile(line);
        return true;
    }

    public static String getHash(String accountNumber) {
        HashMap<String, String> users = readFile();
        
        String hash = users.get(accountNumber);
        if (hash != null && !hash.matches("[A-Za-z0-9]+")) throw new RuntimeException("Bad hash");

        return users.get(hash);
    }

    public static Collection<String> getAccountNumbers() {
        HashMap<String, String> users = readFile();

        return users.values();
    }

    public static boolean removeUser(String accountNumberToRemove) {
        HashMap<String, String> users = readFile();

        if (users.get(accountNumberToRemove) != null)
            users.remove(accountNumberToRemove);
        else return false;

        for (String s: users.keySet());

        return true;
    }
}
