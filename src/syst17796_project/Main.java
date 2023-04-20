package syst17796_project;

/**
 * Main class used to start the game
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Blackjack! Type 'start' to begin or 'exit' to quit.");
            String input = scanner.nextLine();

            if (input.equals("start")) {
                Game blackjack = new Game();
                break;
            } else if (input.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
}