package syst17796_project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 */
import java.util.Scanner;

public class Player extends Person {

    Scanner input = new Scanner(System.in);

    public Player() {
        super.setName("Player");

    }

    public void makeDecision(Deck deck, Deck discard) {

    int decision = 0;
    boolean getNum = true;

    while (getNum) {
        try {
            System.out.println("Your turn: 1) Hit or 2) Stand");
            decision = input.nextInt();
            getNum = false;
        } catch (Exception e) {
            System.out.println("Invalid");
            input.next();
        }
    }

    if (decision == 1) {
        this.hit(deck, discard);
        if (this.getHand().calculatedValue() > 21) {
            System.out.println("Bust.");
        } else {
            this.makeDecision(deck, discard);
        }
    } else {
        System.out.println("Stand.");
    }

}


}