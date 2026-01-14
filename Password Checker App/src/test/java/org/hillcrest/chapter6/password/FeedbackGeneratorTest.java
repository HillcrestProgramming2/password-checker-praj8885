package test.java.org.hillcrest.chapter6.password;

import static org.junit.jupiter.api.Assertions.*;

import main.java.org.hillcrest.chapter6.password.FeedbackGenerator;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the FeedbackGenerator utility class.
 */
public class FeedbackGeneratorTest {

    @Test
    public void testFeedbackForWeakPassword() {
        // "12345" fails almost everything except digits
        String feedback = FeedbackGenerator.generateFeedback("12345");

        assertTrue(feedback.contains("Increase the length"));
        assertTrue(feedback.contains("uppercase"));
        assertTrue(feedback.contains("lowercase"));
        assertTrue(feedback.contains("special"));
    }

    @Test
    public void testFeedbackMissingUppercase() {
        String feedback = FeedbackGenerator.generateFeedback("password123!");

        assertTrue(feedback.contains("uppercase"));
        assertFalse(feedback.contains("lowercase")); // already has lowercase
        assertFalse(feedback.contains("number"));    // already has digits
        assertFalse(feedback.contains("special"));   // already has special char
    }

    @Test
    public void testFeedbackMissingSpecialCharacter() {
        String feedback = FeedbackGenerator.generateFeedback("GoodPass123");

        assertTrue(feedback.contains("special"));
        assertFalse(feedback.contains("uppercase")); // has uppercase
        assertFalse(feedback.contains("lowercase")); // has lowercase
        assertFalse(feedback.contains("number"));    // has digits
    }

    @Test
    public void testStrongPasswordHasNoFeedback() {
        String feedback = FeedbackGenerator.generateFeedback("Secure@2024");

        assertEquals("", feedback);
    }
}