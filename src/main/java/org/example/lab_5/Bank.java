package org.example.lab_5;

import org.example.lab_5.exceptions.AccountNotFoundException;
import org.example.lab_5.exceptions.InsufficientFundsException;
import org.example.lab_5.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialBalance) throws NegativeAmountException {
        BankAccount newAccount = new BankAccount(accountName, 1 + accounts.size());
        newAccount.deposit(initialBalance);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        return accounts.stream().filter(account -> account.getAccountNumber() == accountNumber)
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Account not found by id: " + accountNumber));
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, NegativeAmountException, InsufficientFundsException {
        findAccount(toAccountNumber).deposit(findAccount(fromAccountNumber).withdraw(amount));
    }
}
