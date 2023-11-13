package org.example.lab_6;

import org.example.lab_6.exceptions.InvalidCinemaParameters;

public class Main {
    public static void main(String[] args) throws InvalidCinemaParameters {
        Cinema cinema = new Cinema(5, 10, 20);
        cinema.autoBook(1, 5);
        cinema.autoBook(1, 10);
        cinema.printSeatingArrangement(1);
    }
}
