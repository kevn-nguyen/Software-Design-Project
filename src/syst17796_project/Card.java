package syst17796_project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.

 */
public class Card implements Comparable<Card>{

     private Suit suit;
     private Rank rank;


    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    public int getValue(){
        return rank.rankValue;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");

    }

    
    @Override
    public int compareTo(Card c) {
        
        if(this.getValue() > c.getValue()){
            return 1;
        }
        else if(this.getValue() < c.getValue()){
            return -1;
        }
        else{
            return 0;
        }
    }
}