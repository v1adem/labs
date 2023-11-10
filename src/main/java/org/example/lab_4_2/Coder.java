package org.example.lab_4_2;

public class Coder {
    public static String vowelsCode(String input) {
        String vowels = "aeiou";
        return input.chars().mapToObj(symbol -> {
            if (vowels.contains(Character.toString(symbol))){
                return (char) (vowels.lastIndexOf(symbol)) + 1;
            }
            return (char) symbol;
        }).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }
    public static String consonantsCode(String input) {
        String passVowels = "dhnt";
        String anotherCons = "bcfgjklmpqrsvwxyz";
        return input.chars().mapToObj(symbol -> {
            if (passVowels.contains(Character.toString(symbol))){
                return (char) (symbol + 2);
            }
            if (anotherCons.contains(Character.toString(symbol))) {
                return (char) (symbol + 1);
            }
            return (char) symbol;
        }).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }
}
