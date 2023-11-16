package org.example.lab_7.exceptions;

import lombok.NonNull;
import org.example.lab_7.User;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(@NonNull String message){
        super(message);
    }
}
