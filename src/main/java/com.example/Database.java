package com.example;

import java.io.File;
import java.io.FileWriter;

public class Database {
    
    private void writeToFile(String textToWrite) {
        try {
            FileWriter fw = new FileWriter(new File("database.csv"));
            fw.append(textToWrite);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(String userID, String accountNumber, String passwordHash) {

        

        return true;
    }
}
