package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BendingSpoonsTest {
    @Test
    void isPalindrome_Palindrome_true() {
        // given
        final var str = "1,mad aM1";
        // when
        final var result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }
}