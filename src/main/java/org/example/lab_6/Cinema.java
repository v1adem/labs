package org.example.lab_6;

import java.util.Arrays;
import java.util.Optional;

public class Cinema {
    public int[][][] cinema;
    //cinema[hallNumber][rowNumber][seat]

    public Cinema(int halls, int rows, int seats){
        cinema = new int[halls][rows][seats];
    }

    public boolean bookSeats(int hallNumber, int rowNumber, int[] seats){
        if(hallNumber > cinema.length || rowNumber > cinema[0].length){
            return false;
        }

        Arrays.stream(seats).forEach(seat -> cinema[hallNumber][rowNumber][seat] = 1);
        return true;
    }

    public boolean cancelBooking(int hallNumber, int rowNumber, int[] seats){
        if(hallNumber > cinema.length || rowNumber > cinema[0].length){
            return false;
        }

        Arrays.stream(seats).forEach(seat -> cinema[hallNumber][rowNumber][seat] = 0);
        return true;
    }

    public boolean checkAvailability(int screen, int numSeats) {
        if(screen > cinema.length || numSeats > cinema[0][0].length){
            return false;
        }
        for (int row = 0; row < cinema[0].length; row++){
            row: for(int fp = 0; fp < cinema[screen][row].length - numSeats; fp++){
                for (int sp = 0; sp < numSeats; sp++){
                    if (cinema[screen][row][fp + sp] == 1){
                        fp += sp;
                        continue row;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber){
        //TODO
    }

    public Optional<int[]> findBestAvailable(int hallNumber, int numSeats){
        if(hallNumber > cinema.length || numSeats > cinema[0][0].length){
            return Optional.empty();
        }
        int outerMid = cinema[0][0].length / 2;

        int minDiff = Integer.MAX_VALUE;
        int resultIndex = -1;

        for(int row = 0; row < cinema[0].length; row++){
            int[] outerSeats = cinema[hallNumber][row];
            for (int i = 0; i <= outerSeats.length - numSeats; i++) {
                if(!isAvailableSeats(cinema[hallNumber][row], i, numSeats)){
                    continue;
                }
                int subarrayMid = i + numSeats / 2;

                int diff = Math.abs(outerMid - subarrayMid);

                if (diff < minDiff) {
                    minDiff = diff;
                    resultIndex = i;
                }
            }
        }
        if (resultIndex != -1) {
            int[] bestSeats = new int[numSeats];
            for (int i = 0; i < bestSeats.length; i++) {
                bestSeats[i] = resultIndex++;
            }
            return Optional.of(bestSeats);
        }
        return Optional.empty();
    }

    private boolean isAvailableSeats(int[] row, int startSeat, int numSeats){
        for (; startSeat < numSeats; startSeat++) {
            if(row[startSeat] == 1){
                return false;
            }
        }
        return true;
    }
}
