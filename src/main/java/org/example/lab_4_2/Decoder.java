package org.example.lab_4_2;

public class Decoder {
    public static String decode(String word) {
        if (word.matches(".*\\d+.*")) {
            return vowelsDecode(word);
        }
        return consonantsDecode(word);
    }
    private static String vowelsDecode(String input) {
        return input.chars()
                .mapToObj(symbol -> switch (symbol) {
                    case '1' -> 'a';
                    case '2' -> 'e';
                    case '3' -> 'i';
                    case '4' -> 'o';
                    case '5' -> 'u';
                    default -> (char) symbol;
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
    private static String consonantsDecode(String input) {
        String passVowels = "bfjpv";
        String anotherCons = "cdghklmnqrstwxyz";
        return input.chars().mapToObj(symbol -> {
            if (passVowels.contains(Character.toString(symbol))){
                return (char) (symbol - 2);
            }
            if (anotherCons.contains(Character.toString(symbol))) {
                return (char) (symbol - 1);
            }
            return (char) symbol;
        }).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }
}
