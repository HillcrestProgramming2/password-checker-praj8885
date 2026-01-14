package main.java.org.hillcrest.chapter6.password;

import java.util.Scanner;

/**
 * Main application class for the Password Strength Checker.
 * Prompts the user for a password, evaluates its strength,
 * and prints feedback for improvement.
 */
public class PasswordCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to evaluate: ");
        String password = scanner.nextLine();

        // Evaluate criteria
        int score = CriteriaChecker.evaluateCriteria(password);
        String strength = CriteriaChecker.determineStrength(score);

        // Generate feedback
        String feedback = FeedbackGenerator.generateFeedback(password);

        // Output results
        System.out.println("\nPassword Strength: " + strength + " (" + score + "/5)");

        if (!feedback.isEmpty()) {
            System.out.println("Suggestions to improve your password:");
            System.out.println(feedback);
        }

        scanner.close();
    }
}