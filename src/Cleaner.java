import java.util.Random;

public class Cleaner extends Human{
    private boolean answer;
    private final Player player;
    private final Table table;

    public Cleaner(Player player, Table table){
        this.player = player;
        this.table = table;
    }

    public void cleanOrNot(){
        Random random = new Random();
        answer = random.nextBoolean();
    }

    public void greeting(){
        System.out.println("Cleaner: Hi " + player.name + ". I'm here to clean everything.");
    }

    public void speak(){
        int phrase = random.nextInt(phrases.length);
        System.out.println("Cleaner: Give me some time and everything will be cleaned." +
                "\nCleaner:" + phrases[phrase]);
    }

    public void cleanTable() {
        cleanOrNot();

        if (answer) {
            player.opinion++;
            setReputation(2);
            greeting();
            speak();
            System.out.println("Cleaner: Table " + (table.getNumber() + 1) + " was cleaned :) ");
            goodBye();
        }
        else {
            player.opinion--;
            setReputation(-1);
            greeting();
            speak();
            goodBye();
            System.out.println("Cleaner: Table " + (table.getNumber() + 1)  + " was not cleaned :( ");
        }
    }

    public void goodBye(){
        if(answer){
            System.out.println("Cleaner: " + player.name + ", my work is done here.");
        }
        else{
            System.out.println("Cleaner: " + player.name + ", I don't have time to clean your table.");
        }
    }
}

