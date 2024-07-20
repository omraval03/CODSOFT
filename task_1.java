import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.println("Enter your guess:");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your current score is: " + score);
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
