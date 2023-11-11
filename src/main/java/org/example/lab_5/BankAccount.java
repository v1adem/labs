package org.example.lab_5;

import lombok.Getter;
import org.example.lab_5.exceptions.InsufficientFundsException;
import org.example.lab_5.exceptions.NegativeAmountException;

public class BankAccount {
    @Getter
    private final int accountNumber;
    private final String accountName;
    private double balance;

    public BankAccount(String name, int number) {
        accountName = name;
        accountNumber = number;
        balance = 0.0d;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0.0d) {
            throw new NegativeAmountException("Amount of deposit is negative");
        }
        balance += amount;
    }

    public double withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0.0d) {
            throw new NegativeAmountException("Amount of withdraw is negative: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException("User haven`t enough money on account\nBalance: " + balance
                    + " Amount of withdraw: " + amount);
        }
        balance -= amount;
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return String.format("#: %s / Name: %s / Balance: %s", accountNumber, accountName, balance);
    }
}
