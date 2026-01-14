package main.java.org.hillcrest.chapter6.password;

/**
 * Utility class that evaluates a password based on five criteria:
 * length, uppercase, lowercase, digit, and special character.
 * All methods are static because this class is not meant
 * to be instantiated.
 */
public class CriteriaChecker {

    /**
     * Evaluates the password and returns how many criteria it meets (0–5).
     *
     * @param password the password to evaluate
     * @return number of criteria satisfied
     */
    public static int evaluateCriteria(String password) {
        int score = 0;

        // 1. Length check
        if (password.length() >= 8) {
            score++;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChars = "!@#$%^&*()-+=";

        // Loop through characters to check remaining criteria
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (specialChars.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }

        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        return score;
    }

    /**
     * Converts a numeric score into a strength label.
     *
     * @param score number of criteria met
     * @return "Weak", "Moderate", or "Strong"
     */
    public static String determineStrength(int score) {
        if (score <= 2) {
            return "Weak";
        } else if (score == 3) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }
}