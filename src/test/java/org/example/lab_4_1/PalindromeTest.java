package org.example.lab_4_1;


import org.junit.jupiter.api.Test;

import static org.example.lab_4_1.Palindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    @Test
    public void testPalindrome() {
        assertTrue(isPalindrome("Was it a car or a cat I saw"));
        assertTrue(isPalindrome("Mr. Owl ate my metal worm"));
        assertFalse(isPalindrome("not a palindrome"));
    }

    @Test
    public void testIgnoreSpaces() {
        assertTrue(isPalindrome("ab c cba"));
    }

    @Test
    public void testIgnoreRegister() {
        assertTrue(isPalindrome("ABcBa"));
    }
}