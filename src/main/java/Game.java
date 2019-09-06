import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();

    private Deck deck = new Deck();
    private int numberOfPlayers;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void addPlayers(){
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(i);
            players.add(player);
        }
    }

    public void dealCard() {
        int numberOfCardPerPlayer = deck.sizeOfDeck() / players.size();
        for (int i = 0; i < numberOfCardPerPlayer; i++) {
            for(int j=0;j<players.size();j++){
                Player player = players.get(j);
                Card card = deck.getCard();//remove card from deck
                player.addCard(card);
                player.printCards();
            }
        }

        System.out.println("number of cards left " + deck.sizeOfDeck());
        //System.out.println(deck.);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void playGame(){
        addPlayers();
        deck.shuffle();
        dealCard();
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Start Game");
        System.out.println("Enter number of players between 1 and 52?");
        int numberOfPlayers = Integer.parseInt(inputScanner.nextLine());
        if(numberOfPlayers < 1 || numberOfPlayers > 52) {
            System.out.println("Number of players must be between 1 and 52, please restart game");
            System.exit(0);
        }

        System.out.println("Number of Players: " + numberOfPlayers);
        Game game = new Game(numberOfPlayers);
        game.playGame();
    }
}
