package org.example.lab_2;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter
public class DVD extends Item{
    private int duration;
    public DVD(String title, int duration){
        super(title);
        this.duration = duration;
    }

    @Override
    public boolean borrowItem(){
        if (isBorrowed()) {
            return false;
        }
        setBorrowed(true);
        return true;
    }

    @Override
    public boolean returnItem(){
        if (!isBorrowed()) {
            return false;
        }
        setBorrowed(false);
        return true;
    }
}
