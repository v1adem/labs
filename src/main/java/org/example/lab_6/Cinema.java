package org.example.lab_6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.lab_6.exceptions.InvalidCinemaParameters;

import java.util.Arrays;
import java.util.Optional;

public class Cinema {
    public int[][][] cinema;
    //cinema[hallNumber][rowNumber][seat]

    public Cinema(int halls, int rows, int seats) {
        cinema = new int[halls][rows][seats];
    }

    public boolean bookSeats(int hallNumber, int rowNumber, int[] seats) throws InvalidCinemaParameters {
        if (hallNumber > cinema.length || rowNumber > cinema[0].length || seats.length > cinema[0][0].length) {
            throw new InvalidCinemaParameters("There are no such Hall/Row/Seats");
        }

        Arrays.stream(seats).forEach(seat -> cinema[hallNumber][rowNumber][seat] = 1);
        return true;
    }

    public boolean cancelBooking(int hallNumber, int rowNumber, int[] seats) throws InvalidCinemaParameters {
        if (hallNumber > cinema.length || rowNumber > cinema[0].length || seats.length > cinema[0][0].length) {
            throw new InvalidCinemaParameters("There are no such Hall/Row/Seats");
        }

        Arrays.stream(seats).forEach(seat -> cinema[hallNumber][rowNumber][seat] = 0);
        return true;
    }

    public boolean checkAvailability(int screen, int numSeats) throws InvalidCinemaParameters {
        if (screen > cinema.length || numSeats > cinema[0][0].length) {
            throw new InvalidCinemaParameters("There are no such Hall/Seats");
        }
        for (int row = 0; row < cinema[0].length; row++) {
            row:
            for (int fp = 0; fp < cinema[screen][row].length - numSeats; fp++) {
                for (int sp = 0; sp < numSeats; sp++) {
                    if (cinema[screen][row][fp + sp] == 1) {
                        fp += sp;
                        continue row;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) throws InvalidCinemaParameters {
        if (hallNumber > cinema.length) {
            throw new InvalidCinemaParameters("There is no such Hall");
        }

        System.out.print("  Seats: ");
        for (int i = 1; i <= cinema[hallNumber][0].length; i++) {
            System.out.printf("%2s ", i);
        }
        System.out.println();

        for (int i = 0; i < cinema[hallNumber].length; i++) {
            System.out.print("  Row " + String.format("%2d", (i + 1)) + ": ");
            for (int j = 0; j < cinema[hallNumber][i].length; j++) {
                System.out.print(cinema[hallNumber][i][j] == 0 ? "\u001B[32mO\u001B[0m " : "\u001B[31mX\u001B[0m "); // Виводимо "O" для 0 і "X" для 1
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    //cinema[hallNumber]
    public Optional<RowAndSeats> findBestAvailable(int hallNumber, int numSeats) throws InvalidCinemaParameters {
        if (hallNumber > cinema.length || numSeats > cinema[0][0].length) {
            throw new InvalidCinemaParameters("There are no such Hall/Seats");
        }
        int outerMid = cinema[0][0].length / 2;

        int minDiff = Integer.MAX_VALUE;
        int resultIndex = -1;
        int resultRow = -1;

        for (int row = 0; row < cinema[0].length; row++) {
            int[] outerSeats = cinema[hallNumber][row];
            for (int i = 0; i <= outerSeats.length - numSeats; i++) {
                if (!isAvailableSeats(cinema[hallNumber][row], i, numSeats)) {
                    continue;
                }
                int subarrayMid = i + numSeats / 2;

                int diff = Math.abs(outerMid - subarrayMid);

                if (diff < minDiff) {
                    minDiff = diff;
                    resultIndex = i;
                    resultRow = row;
                }
            }
        }
        if (resultIndex != -1) {
            int[] bestSeats = new int[numSeats];
            for (int i = 0; i < bestSeats.length; i++) {
                bestSeats[i] = resultIndex++;
            }
            return Optional.of(new RowAndSeats(bestSeats, resultRow));
        }
        return Optional.empty();
    }

    private boolean isAvailableSeats(int[] row, int startSeat, int numSeats) {
        for (; startSeat < numSeats; startSeat++) {
            if (row[startSeat] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean autoBook(int hallNumber, int numSeats) throws InvalidCinemaParameters {
        if (findBestAvailable(hallNumber, numSeats).isPresent()) {
            RowAndSeats bestSeats = findBestAvailable(hallNumber, numSeats).get();
            bookSeats(hallNumber, bestSeats.getRow(), bestSeats.getSeats());
            return true;
        }
        return false;
    }

    @Getter
    @AllArgsConstructor
    static class RowAndSeats {
        private int[] seats;
        private int row;
    }
}
