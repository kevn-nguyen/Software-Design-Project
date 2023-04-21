package syst17796_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testStartRound() {
        // Test that the game starts with a shuffled deck
        assertEquals(52, game.deck.cardsLeft());

        // Test that the game starts with an empty discarded deck
        assertEquals(0, game.discarded.cardsLeft());

        // Test that the game starts with a new dealer and player
        assertNotNull(game.dealer);
        assertNotNull(game.player);

        // Test that the game starts with zero wins, losses, and ties
        assertEquals(0, game.wins);
        assertEquals(0, game.losses);
        assertEquals(0, game.ties);
    }

    @Test
    public void testPause() {
        // Test that the pause method waits for the specified time
        long start = System.currentTimeMillis();
        Game.pause();
        long end = System.currentTimeMillis();
        assertTrue(end - start >= 2000);
    }

    @Test
    public void testStartGame() {
        Game game = new Game();
        assertNotNull(game.deck);
        assertNotNull(game.discarded);
        assertNotNull(game.dealer);
        assertNotNull(game.player);
        assertEquals(0, game.wins);
        assertEquals(0, game.losses);
        assertEquals(0, game.ties);
        assertEquals(52, game.deck.cardsLeft());
        assertEquals(0, game.discarded.cardsLeft());
        assertFalse(game.dealer.hasBlackjack());
        assertFalse(game.player.hasBlackjack());
        assertFalse(game.player.getHand().calculatedValue() > 21);
        assertFalse(game.dealer.getHand().calculatedValue() > 21);
    }

}