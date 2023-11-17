package org.example.lab_7.exceptions;

import lombok.NonNull;

public class NegativeStockException extends Exception{
    public NegativeStockException(@NonNull String message){
        super(message);
    }
}
