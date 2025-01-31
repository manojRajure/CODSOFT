/*
Task 1: Number Guessing Game

1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 */


import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 6; 
        int rounds = 3; 
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            int targetNumber = random.nextInt(1,100);
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round + ":");

            while (!guessed && attempts < maxAttempts) {
                System.out.print("Enter your guess (between 1 to 100 ): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessed = true;
                    totalScore += maxAttempts - attempts + 1; // Award points based on remaining attempts
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you ran out of attempts. The number was: " + targetNumber);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your total score: " + totalScore + " out of " + rounds * maxAttempts);

        scanner.close();
    }
}
