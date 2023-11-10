package org.example.lab_4_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);

        String inputVowelCoded = Coder.vowelsCode(input);
        System.out.println("Vowels coded: " + inputVowelCoded);

        String inputConsonantsCoded = Coder.consonantsCode(input);
        System.out.println("Consonants coded: " + inputConsonantsCoded);

        System.out.println("Vowels decoded: " + Decoder.decode(inputVowelCoded));
        System.out.println("Consonants decoded: " + Decoder.decode(inputConsonantsCoded));
    }
}