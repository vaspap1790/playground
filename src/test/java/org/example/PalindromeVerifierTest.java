package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeVerifierTest {

    @Test
    void isPalindrome_Palindrome_true() {
        // given
        final var str = "1,mad aM1";
        // when
        final var result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }

    @Test
    void isPalindrome_NotPalindrome_false() {
        // given
        final var str = "hello";
        // when
        final var result = PalindromeVerifier.isPalindrome(str);
        // then
        assertFalse(result);
    }

    @Test
    void isPalindrome_Empty_false() {
        assertFalse(PalindromeVerifier.isPalindrome(""));
    }

    @Test
    void isPalindrome_Null_false() {
        assertFalse(PalindromeVerifier.isPalindrome(null));
    }
}