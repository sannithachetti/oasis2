import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to start the game round
    public static void startGame(int maxAttempts, int roundNumber, int[] score) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;  // Generate random number between 1 and 100
        int attempts = 0;
        boolean hasWon = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("\nRound " + roundNumber + " - Guess the number between 1 and 100.");

        // Loop until the user guesses correctly or max attempts are reached
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number correctly.");
                hasWon = true;
                score[roundNumber - 1] = 100 - (attempts * 10);  // Points decrease based on attempts
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!hasWon) {
            System.out.println("You've used all attempts! The correct number was: " + randomNumber);
            score[roundNumber - 1] = 0;  // No points if failed to guess correctly
        }

        System.out.println("End of round " + roundNumber + ". Your score this round: " + score[roundNumber - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds;
        int maxAttempts = 5;  // Set maximum attempts per round

        // Get number of rounds from user
        System.out.print("Enter the number of rounds you want to play: ");
        rounds = sc.nextInt();

        int[] score = new int[rounds];  // Array to store scores for each round

        // Loop through the rounds
        for (int round = 1; round <= rounds; round++) {
            startGame(maxAttempts, round, score);
        }

        // Display total score after all rounds
        int totalScore = 0;
        for (int s : score) {
            totalScore += s;
        }
        System.out.println("\nGame over! Your total score after " + rounds + " rounds is: " + totalScore);

        // Optionally close the scanner
        sc.close();
    }
}