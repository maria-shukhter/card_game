import java.util.*;

public class Deck {
    private Queue<Card> deck = new ArrayDeque<Card>();

    public Deck() {
        generateDeck();
    }

    public void generateDeck(){
        System.out.println("generate Deck");
        for(Suit suit: Suit.values()){
            for(CardValue cardValue: CardValue.values()){
                Card card = new Card(suit, cardValue);
                deck.add(card);
            }

        }
        System.out.println(deck);
    }

    public Card getCard(){
        return deck.remove();
    }

    public void shuffle(){
        System.out.println("Shuffle");
        ArrayList<Card> list = new ArrayList<Card>(deck);
        Collections.shuffle(list);
        deck = new ArrayDeque<Card>(list);
        System.out.println(deck);
    }

    public int sizeOfDeck(){
        return deck.size();
    }
}
