import java.util.Random;

public class Barman extends Human {

    private final Player player;
    private final Deck deck;
    private boolean win;

    public Barman(Player player, Deck deck){
        this.player = player;
        this.deck = deck;
    }

    public void speak(){
        System.out.println("Barman: First I need to shuffle the deck. Wait a minute.");
        int phrase = random.nextInt(phrases.length);
        System.out.println("Barman: " + phrases[phrase] + ".\nPlayer: Stop talking and shuffle the deck.");
    }

    public void goodBye(){
        if(win){
            System.out.println("Barman: " + player.name + ", luck was on your side." +
                    " I hope I never see you again.");
        }
        else {
            System.out.println("Barman: I wish I had a chance to play with you more often. Bye.");
        }
    }

    public void playGame(){

        Random random = new Random();
        speak();
        deck.qualityCheck();

        deck.addCards();
        int rand1 = random.nextInt(deck.getDeckWith().size());
        int rand2 = random.nextInt(deck.getDeckWith().size());
        Card card1 = deck.getDeckWith().get(rand1);
        Card card2 = deck.getDeckWith().get(rand2);
        card1.findValue();
        card2.findValue();

        if(card1.getValue() < card2.getValue()){

            System.out.println("Game: Player " + player.name + " won with card " +
                    card2.getSuit() + " " + card2.getRank() + ", value = " + card2.getValue() +
                    ". Player received 100 $");
            win = true;
            player.setMoney(100);
            player.opinion += 10;
        }
        else{

            System.out.println("Game: Barman won with card " +
                    card1.getSuit() + " " + card1.getRank() + ", value = " + card1.getValue() +
                    ". Player lose 50 $");
            player.pay(50);
            player.opinion -= 10;
        }
        goodBye();

    }
    public void greeting(){
        System.out.println("Barman: Hello " + player.name + ". I have a special offer for you." +
                " If you beat me at cards, I'll give you 100 $.\nBut if you loose, I receive 50 $. Deal ?");
        boolean answer = random.nextBoolean();
        if(answer){
            System.out.println("Player: Okay, Let's play.");
            playGame();
        }
        else {
            System.out.println("Player: No, thanks.");
            goodBye();
        }
    }
}
