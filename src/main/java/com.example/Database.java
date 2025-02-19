package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Database {
    
    private static void writeToFile(String textToWrite) {
        try {
            FileWriter fw = new FileWriter(new File("database.csv"));
            fw.append(textToWrite);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.csv"));
            HashMap<String, String> map = new HashMap<>();
            while (reader.ready()) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                map.put(parts[0], parts[1]);
            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean addUser(String accountNumber, String passwordHash) {

        String line = accountNumber + "," + passwordHash;
        writeToFile(line);

        return true;
    }

    public static String getHash(String accountNumber) {
        HashMap<String, String> users = readFile();
        
        return users.get(accountNumber);
    }

    public static String nextAccountNumber() {
        HashMap<String, String> users = readFile();
        int max = 0;
        for (String accountNumber: users.values()) 
            max = Math.max(max, Integer.parseInt(accountNumber));
        
        return Integer.toString(max);
    }

    public static boolean removeUser(String accountNumber) {
        HashMap<String, String> users = readFile();

        if (users.get(accountNumber) != null) {
            users.remove(accountNumber);
            return true;
        }

        return false;
    }
}
