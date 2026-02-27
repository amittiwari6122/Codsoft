import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String choice;
        System.out.println("===== Welcome to Number Guessing Game =====");
        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean isGuessed = false;
            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have only " + maxAttempts + " attempts to guess it.");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = input.nextInt();
                attempts++;
                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed it right.");
                    score++;
                    isGuessed = true;
                    break;
                } 
                else {
                    int difference = Math.abs(secretNumber - userGuess);
                    if (difference <= 3) {
                        System.out.println("Very Very Close!");
                    } 
                    else if (difference <= 10) {
                        System.out.println("You are close!");
                    } 
                    else {
                        System.out.println("You are far!");
                    }

                    if (userGuess < secretNumber) {
                        System.out.println("Your guess is too low.");
                    } 
                    else {
                        System.out.println("Your guess is too high.");
                    }
                }
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }
            if (!isGuessed) {
                System.out.println("Sorry! You used all attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }
            System.out.println("Your current score: " + score);
            System.out.print("\nDo you want to play again? (yes/no): ");
            choice = input.next();
        } while (choice.equalsIgnoreCase("yes"));
        System.out.println("\nFinal Score: " + score);
        System.out.println("Thank you for playing!");
        input.close();
    }
}
