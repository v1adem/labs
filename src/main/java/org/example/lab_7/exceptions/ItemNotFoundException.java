package org.example.lab_7.exceptions;

import lombok.NonNull;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(@NonNull String message){
        super(message);
    }
}
