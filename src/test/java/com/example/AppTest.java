
package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testPositivePalindrome() {
        assertTrue(App.isPalindrome("madam"));
    }

    @Test
    public void testNegativePalindrome() {
        assertFalse(App.isPalindrome("hello"));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(App.isPalindrome("a"));
    }

    @Test
    public void testCaseInsensitivePalindrome() {
        assertTrue(App.isPalindrome("Madam"));
    }

    @Test
    public void testEvenLengthPalindrome() {
        assertTrue(App.isPalindrome("noon"));
    }

    @Test
    public void testIntentionalFailure() {
        assertTrue(App.isPalindrome("hello"));
    }
}
