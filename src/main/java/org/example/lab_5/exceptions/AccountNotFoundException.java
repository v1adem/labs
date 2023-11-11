package org.example.lab_5.exceptions;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(String message){
        super(message);
    }
}
