package main.java.org.hillcrest.chapter6.password;

/**
 * Utility class for generating feedback based on which
 * password criteria are not met. All methods are static
 * because this class is not meant to be instantiated.
 */
public class FeedbackGenerator {

    /**
     * Generates a feedback string listing suggestions for
     * improving the password. If the password meets all
     * criteria, an empty string is returned.
     *
     * @param password the password to evaluate
     * @return feedback string with suggestions
     */
    public static String generateFeedback(String password) {
        String feedback = "";

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChars = "!@#$%^&*()-+=";

        // Loop through characters to check criteria
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

        // Build feedback string based on missing criteria
        if (password.length() < 8) {
            feedback += "- Increase the length to at least 8 characters.\n";
        }
        if (!hasUpper) {
            feedback += "- Add at least one uppercase letter.\n";
        }
        if (!hasLower) {
            feedback += "- Add at least one lowercase letter.\n";
        }
        if (!hasDigit) {
            feedback += "- Add at least one number.\n";
        }
        if (!hasSpecial) {
            feedback += "- Include at least one special character.\n";
        }

        return feedback;
    }
}