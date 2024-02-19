import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;  // Minimum range value
        int maxRange = 100; // Maximum range value
        int attemptsLimit = 5; // Maximum number of attempts
        int totalRounds = 0; // Initialize total rounds played
        int totalScore = 0; // Initialize total score

        System.out.println("Welcome to the Number Game!");

        boolean playAgain = true;

        // Main game loop
        while (playAgain) {
            totalRounds++; // Increment total rounds played for each new game
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0; // Initialize attempts count
            int score = 0; // Initialize score for this round

            System.out.println("Round " + totalRounds + ": I have selected a number between " + minRange + " and " + maxRange + ". Guess the number!");

            // Game loop for each round
            while (true) {
                try {
                    // Prompt user for guess
                    System.out.print("Attempt " + (attempts + 1) + "/" + attemptsLimit + ": Enter your guess: ");
                    int guess = scanner.nextInt();

                    // Compare user's guess with random number
                    if (guess == randomNumber) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        score = attemptsLimit - attempts; // Calculate score for this round
                        totalScore += score; // Update total score
                        break;
                    } else if (guess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    attempts++;

                    // Check if user has used all attempts
                    if (attempts >= attemptsLimit) {
                        System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
                        break;
                    }
                } catch (InputMismatchException e) {
                    // Handle invalid input
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); // Clear the invalid input from the scanner
                }
            }

            // Display score for this round and total score
            System.out.println("Your score for this round: " + score);
            System.out.println("Your total score: " + totalScore);

            // Check if player wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            if (!playAgainChoice.equals("yes")) {
                playAgain = false;
            }
        }

        // End of game
        System.out.println("Thank you for playing the Number Game!");
        scanner.close();
    }
                          }