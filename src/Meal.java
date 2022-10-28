import java.util.Random;

public class Meal extends Entities{

    private String food;
    private String supply;
    private final Player player;
    private final Menu menu;

    public String getFood() {
        return food;
    }

    public String getSupply() {
        return supply;
    }

    public Meal(Player player, Menu menu){
        this.player = player;
        this.menu = menu;
    }

    public void pickFood(){
        Random random = new Random();
        int rand1 = random.nextInt(menu.getFoodList().length);
        int rand2 = random.nextInt(menu.getSuppliesList().length);
        food = menu.getFoodList()[rand1];
        supply = menu.getSuppliesList()[rand2];
        System.out.println("Player: " + player.name + " wants to order " + food + " with " + supply + ".");
    }

    public void stopListCheck(){
        menu.stopList();
        if(food.equals(menu.getFoodFromSL())){
            player.opinion--;
            System.out.println("Food, ordered by Player " + player.name + " was in Stop-list.\n" +
                    "Player should pick another food.");
            pickFood();
        }
        else if(supply.equals(menu.getSupplyFromSL())){
            player.opinion--;
            System.out.println("Supply, wanted by Player " + player.name + " was in Stop-list.\n" +
                    "Player should pick another supply.");
            pickFood();
        }
        else{
            System.out.println("Meal, wanted by Player " + player.name + " was not in Stop-list.");
        }
    }

    public void qualityCheck() {

        qualityIndex = random.nextInt(3) + 1;
        System.out.println("\n---Check the meal appearance---");
        super.qualityCheck();
        if (qualityIndex == 1) {
            player.opinion--;
            System.out.println("Player: What a bad chef :(");
            change("Meal");

        } else if (qualityIndex == 2) {
            player.opinion++;
            System.out.println("Player: Chef did his best :|");

        } else {
            player.opinion += 2;
            System.out.println("Player: Wow, Chef is a real professional :) ");
        }
    }
}

