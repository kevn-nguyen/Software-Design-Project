package syst17796_project;

/**
 * Used for shared logic between the dealer and player
 */
public abstract class Person {

    private Hand hand;
    private String name;

    
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    
    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }


    public void printHand(){
        System.out.println(this.name + "'s hand:");
        System.out.println(this.hand + " Value: " + this.hand.calculatedValue());
    }

    public void hit(Deck deck, Deck discard){

        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
        Game.pause();

    }

    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }



}