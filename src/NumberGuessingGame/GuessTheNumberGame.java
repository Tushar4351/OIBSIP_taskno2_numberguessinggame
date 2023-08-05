package NumberGuessingGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    static int totalScore = 0;
    static int totalRounds = 0;
    
    public static void main(String[] args) {
    	GuessTheNumberGame game = new GuessTheNumberGame();
        game.displayMenu();
    }

    public void displayMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------\n");
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("1. Play the Game");
        System.out.println("2. Score Board");
        System.out.println("3. Exit the Game");
        System.out.println("\n----------------------");

        try {
            System.out.print("Press any number to continue: ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\nWhat would you like the range of numbers to be? ");
                    int numRange = input.nextInt();
                    int randomNumber = generateRandomNumber(numRange);
                    playGame(randomNumber);
                    break;
                case 2:
                    displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\nThanks for playing!");
                    System.exit(0);
                    break;
                default:
                    throw new InputMismatchException("Invalid number pressed...Try again...");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            displayMenu();
        }
    }

    public int generateRandomNumber(int numRange) {
        Random random = new Random();
        return random.nextInt(numRange) + 1;
    }

    public void playGame(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int attempts = 0;

        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            attempts++;
            if (userGuess > randomNumber)
                System.out.println("Lower");
            else if (userGuess < randomNumber)
                System.out.println("Higher");
        } while (randomNumber != userGuess);

        System.out.println();
        if (attempts == 1)
            System.out.println("You guessed the correct number in " + attempts + " try!!");
        else
            System.out.println("You guessed the correct number in " + attempts + " tries!!!");

        totalScore += attempts;
        totalRounds++;
        System.out.println();
        displayMenu();
    }

    public void displayScoreBoard() {
        System.out.println("-------------");
        System.out.println(" Score Board");
        System.out.println("-------------");

        if (totalRounds == 0) {
            System.out.println("No games played yet.");
        } else {
            int averageAttempts = totalScore / totalRounds;
            System.out.println("Total Rounds: " + totalRounds);
            System.out.println("Total Score: " + totalScore);
            System.out.println("Average Attempts per Round: " + averageAttempts);
        }

        System.out.println();
        displayMenu();
    }
}
