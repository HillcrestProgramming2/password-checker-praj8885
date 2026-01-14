package test.java.org.hillcrest.chapter6.password;

import static org.junit.jupiter.api.Assertions.*;

import main.java.org.hillcrest.chapter6.password.CriteriaChecker;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the CriteriaChecker utility class.
 */
public class CriteriaCheckerTest {

    @Test
    public void testWeakPassword() {
        // "12345" → only digits, too short → score should be 1
        int score = CriteriaChecker.evaluateCriteria("12345");
        assertEquals(1, score);
        assertEquals("Weak", CriteriaChecker.determineStrength(score));
    }

    @Test
    public void testModeratePassword() {
        // "password123" → lowercase + digits + length → score should be 3
        int score = CriteriaChecker.evaluateCriteria("password123");
        assertEquals(3, score);
        assertEquals("Moderate", CriteriaChecker.determineStrength(score));
    }

    @Test
    public void testStrongPassword() {
        // "Secure@2024" → meets all 5 criteria
        int score = CriteriaChecker.evaluateCriteria("Secure@2024");
        assertEquals(5, score);
        assertEquals("Strong", CriteriaChecker.determineStrength(score));
    }

    @Test
    public void testMissingSpecialCharacter() {
        // Should be 4/5 because no special character
        int score = CriteriaChecker.evaluateCriteria("GoodPass123");
        assertEquals(4, score);
        assertEquals("Strong", CriteriaChecker.determineStrength(score));
    }

    @Test
    public void testMissingUppercase() {
        int score = CriteriaChecker.evaluateCriteria("lowercase123!");
        assertEquals(3, score); // length + lowercase + digit + special = 4? No uppercase → 4
        assertEquals("Strong", CriteriaChecker.determineStrength(score));
    }
}