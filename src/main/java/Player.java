import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cardsList= new ArrayList<Card>();
    private int number;

    public Player(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addCard(Card card){
        cardsList.add(card);
    }

    public int getNumberOfCard(){
        return cardsList.size();
    }

    public List<Card> getListOfCards(){
        return cardsList;
    }

    public void printCards(){
        System.out.print("for player number " + number+"\t");
        System.out.println(cardsList);
    }
}
