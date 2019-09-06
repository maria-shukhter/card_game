import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;
    public static final int NUMBER_OF_PLAYERS = 5;

    @BeforeEach
    public void init(){
        game = new Game(NUMBER_OF_PLAYERS);
    }
    @Test
    void invitePlayers() {
        assertEquals(0, game.getPlayers().size());
        game.addPlayers();
        assertEquals(NUMBER_OF_PLAYERS, game.getPlayers().size());

    }

    @Test
    void dealCard() {
        game.addPlayers();
        Deck deck = game.getDeck();
        deck.generateDeck();
        deck.shuffle();
        int numberOfCardsForPlayer = deck.sizeOfDeck() / NUMBER_OF_PLAYERS;
        int ostatokOfCardsForPlayer = deck.sizeOfDeck() % NUMBER_OF_PLAYERS;
        game.dealCard();

        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            assertEquals(numberOfCardsForPlayer, game.getPlayers().get(i).getNumberOfCard());
        }
        assertEquals(ostatokOfCardsForPlayer, deck.sizeOfDeck());
    }

    @Test
    void playGame() {

    }
}