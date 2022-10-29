public class Card extends Entities{
    Deck deck = new Deck();
    private final String suit;
    private final String rank;
    private int value;

    public String getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
    public int getValue(){
        return value;
    }
    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public void findValue(){
        deck.cardValue();
        this.value  = deck.getCardWithValue().get(rank);
    }
}

