package syst17796_project;

import java.util.Scanner;

public class Game {

    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, losses, ties;

    public Game(){

        deck = new Deck(true);
        discarded = new Deck();
        dealer = new Dealer();
        player = new Player();
        deck.shuffle();
        startRound();
    }

    private void startRound(){
/*        wins = 0; losses = 0; pushes = 1;
        Card testCard = new Card(Suit.CLUB,Rank.NINE);
        Card testCard2 = new Card(Suit.CLUB, Rank.TEN);*/
        //If this isn't the first time, display the users score and put their cards back in the deck
        if(wins>0 || losses>0 || ties > 0){
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: "+ losses+ " Ties: "+ties);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        //Check to make sure the deck has at least 4 cards left
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

/*        //TEST
        player.getHand().addCard(testCard);
        player.getHand().addCard(testCard2);*/

        //Show the dealers hand with one card face down
        dealer.printFirstHand();

        //Show the player's hand
        player.printHand();

        //Check if dealer has BlackJack to start
        if(dealer.hasBlackjack()){
            //Show the dealer has BlackJack
            dealer.printHand();

            //Check if the player also has BlackJack
            if(player.hasBlackjack()){
                //End the round with a push
                System.out.println("You both have 21 - Tie.");
                ties++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack. You lose.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        //Check if player has blackjack to start
        //If we got to this point, we already know the dealer didn't have blackjack
        if(player.hasBlackjack()){
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }

        //Let the player decide what to do next
        player.makeDecision(deck, discarded);

        //Check if they busted
        if(player.getHand().calculatedValue() > 21){
            System.out.println("You have gone over 21.");
            losses ++;
            startRound();
        }

        //Now it's the dealer's turn
        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        //Check who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("Tie.");
            ties++;
        }

        startRound();
    }

    public static void pause(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}