import java.util.Random;

public class Table extends Entities {
    private Player player;
    private final int number;              // table index

    public int getNumber() {
        return number;
    }

    public Table(int number, Player player){
        this.number = number;
        this.player = player;
    }

    public void qualityCheck() {

        qualityIndex = random.nextInt(3) + 1;
        System.out.println("\n---Check the table state---");
        super.qualityCheck();
        if (qualityIndex == 1) {
            player.opinion--;
            System.out.println("Player: " + player.name + " was not glad to sit at the oldest table :(");

        } else if (qualityIndex == 2) {
            player.opinion++;
            System.out.println("Player: " + player.name + " was glad to receive a good table :|");

        } else {
            player.opinion += 2;
            System.out.println("Player: " + player.name + " was pleased to receive the best table :) ");
        }
    }
}
