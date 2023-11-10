package org.example.lab_4_1;
import org.jetbrains.annotations.NotNull;
public class Palindrome {
    public static boolean isPalindrome(@NotNull String input) {
        input = input.replaceAll("[,.;: /]", "");
        if(input.length() < 2) return false;
        return new StringBuilder(input).reverse().toString().equalsIgnoreCase(input);
    }
}
