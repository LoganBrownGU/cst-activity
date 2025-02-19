package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Database {
    
    private void writeToFile(String textToWrite) {
        try {
            FileWriter fw = new FileWriter(new File("database.csv"));
            fw.append(textToWrite);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, String[]> readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("database.csv"));
            HashMap<String, String[]> map = new HashMap<>();
            while (reader.ready()) {
                String line = reader.readLine();
                String[] parts = line.split(",");
                map.put(parts[0], new String[] {parts[1], parts[2]});
            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addUser(String userID, String accountNumber, String passwordHash) {

        String line = userID + "," + accountNumber + "," + passwordHash;
        writeToFile(line);

        return true;
    }

    public boolean removeUser(String userID) {
        HashMap<String, String[]> users = readFile();

        if (users.get(userID) != null) {
            users.remove(userID);
            return true;
        }

        return false;
    }
}
