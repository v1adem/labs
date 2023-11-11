package org.example.lab_5;

import org.example.lab_5.exceptions.AccountNotFoundException;
import org.example.lab_5.exceptions.InsufficientFundsException;
import org.example.lab_5.exceptions.NegativeAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void init() {
        bank = new Bank();
    }

    @Test
    public void testFindAccount_ShouldReturnAccount() throws NegativeAmountException, AccountNotFoundException {
        BankAccount account = bank.createAccount("John", 999);
        assertEquals(account, bank.findAccount(1));
    }

    @Test
    public void testFindAccount_ShouldThrow() {
        assertThrows(AccountNotFoundException.class, () ->
                bank.findAccount(1));
    }

    @Test
    public void testTransferMoney_Successfully()
            throws NegativeAmountException, InsufficientFundsException, AccountNotFoundException {
        bank.createAccount("John", 999);
        bank.createAccount("Max", 1001);

        bank.transferMoney(1, 2, 999);

        assertEquals(2000, bank.findAccount(2).getBalance());
    }

    @Test
    public void testTransferMoney_ShouldThrow() throws NegativeAmountException {
        bank.createAccount("John", 999);
        bank.createAccount("Max", 1001);

        assertThrows(NegativeAmountException.class, () ->
                bank.transferMoney(1, 2, -1));

        assertThrows(InsufficientFundsException.class, () ->
                bank.transferMoney(1, 2, 1000));
    }
}