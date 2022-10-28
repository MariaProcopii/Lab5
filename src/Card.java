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
    public void qualityCheck() {

        qualityIndex = random.nextInt(3) + 1;
        System.out.println("\n---Check the Card state---");
        super.qualityCheck();
        if (qualityIndex == 1) {
            System.out.println("Player: was not glad to play with old cards :(");
            change("Card");

        } else if (qualityIndex == 2) {
            System.out.println("Player: was glad to receive a good set of cards :|");

        } else {
            System.out.println("Player: was pleased to receive the best set of cards :) ");
        }
    }

}

