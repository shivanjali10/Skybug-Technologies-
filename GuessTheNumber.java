// GuessTheNumber.java

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Define the range
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5; // You can adjust this as needed

        // Create an instance of Scanner class for user input
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        // Outer loop for multiple rounds
        while (playAgain) {
            // Generate a random number within the specified range for each round
            int randomNumber = new Random().nextInt((maxRange - minRange) + 1) + minRange;

            // Welcome message
            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("Guess a number between " + minRange + " and " + maxRange);

            boolean guessedCorrectly = false;
            int attempts = 0;

            // Inner loop for the current round
            while (!guessedCorrectly && attempts < maxAttempts) {
                // Get the user's guess
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                // Compare the user's guess with the generated number
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // Display a message if the user didn't guess correctly within the allowed attempts
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");

        }

        // Close the Scanner
        scanner.close();
    }
}
