package syst17796_project;

/**
 * Handles all Dealer specific operations
 */
public class Dealer extends Person{

    public Dealer(){

        super.setName("Dealer");

    }

    
    public void printFirstHand(){
        System.out.println("Dealer's Hand:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("Second Card is faced down.");
    }



}