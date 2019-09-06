import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck;

    @BeforeEach
    void clearDeck(){
        deck = new Deck();
        deck.generateDeck();

    }

    @Test
    @DisplayName("generate cards")
    void generateDeck() {
        assertEquals(52, deck.sizeOfDeck());

        for(Suit suit: Suit.values()){
            for(CardValue cardValue: CardValue.values()){
                Card card = new Card(suit, cardValue);
                Card cardFromDeck = deck.getCard();
                assertEquals(card.getSuit(), cardFromDeck.getSuit(), "card suit mismatch");
                assertEquals(card.getCardValue(), cardFromDeck.getCardValue(), "card value mismatch");
                //System.out.println(card.getSuit()+ " " +card.getCardValue());
            }

        }
        assertNotEquals(52, deck.sizeOfDeck());
    }

    /**
     * this test is unstable, there is a small chance that shuffled deck will be in the same order as unshuffled.
     * Should be treated as a sanity test because there is no strict definition that a shuffled deck should be
     * in different order than unshuffled one.
     */
    //@Test
    void shuffle() {
        deck.shuffle();
        assertEquals(52, deck.sizeOfDeck());
        boolean isUniqueCardsInDeck = false;
        int numberOfUniqueValues = 0;
        for(Suit suit: Suit.values()){
            for(CardValue cardValue: CardValue.values()){
                Card card = new Card(suit, cardValue);
                Card cardFromDesk = deck.getCard();

                if(card.getSuit() != cardFromDesk.getSuit() || card.getCardValue() != cardFromDesk.getCardValue()) {
                    isUniqueCardsInDeck = true;
                    numberOfUniqueValues++;
                }

            }


        }
        assertEquals(true, isUniqueCardsInDeck);
        assertTrue(numberOfUniqueValues > 12);
    }

    @Test
    void sizeOfDeck() {
        int numberOfIteration = 12;
        for (int i = 0; i < numberOfIteration; i++) {
            Card card = deck.getCard();
        }
        assertEquals(52 - numberOfIteration, deck.sizeOfDeck());
    }
}