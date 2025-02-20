package com.example;

import java.util.Arrays;
import java.util.Set;

public class AccountNumberGenerator {
    private int nextNumber = 0;
    private boolean initialised = false;

    public void initialise(Set<String> accountNumbers) {
        if (accountNumbers == null) {
            this.initialised = true;
            return;
        }

        int max = 0;
        for (String accountNumber: accountNumbers) {
            max = Math.max(max, Integer.parseInt(accountNumber));
        }
        
        this.nextNumber = max + 1;
        this.initialised = true;
    }

    public String nextAccountNumber() {
        if (!this.initialised) throw new IllegalStateException("Generator not initialised");

        String unformattedNumber = Integer.toString(this.nextNumber++);
        while (unformattedNumber.length() < 8)
            unformattedNumber = "0" + unformattedNumber;

        return Helper.insertDots(unformattedNumber);
    }
}
