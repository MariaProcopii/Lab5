public class Cook extends Human {

    private final Meal meal;
    private final Waiter waiter;
    private final Player player;
    private final Table table;

    public Cook(Meal meal, Waiter waiter, Player player, Table table){
        this.meal = meal;
        this.waiter = waiter;
        this.player = player;
        this.table = table;
    }

    public void qualityCheck() {
        greeting();
        speak();
        waiter.speak();
        goodBye();
        if (waiter.polite == 1) {
            player.opinion--;
            System.out.println("Player: " + player.name + " was angry because waiter was too slow :( ");
        } else if (waiter.polite == 2) {
            player.opinion++;
            System.out.println("Player: " + player.name + " was satisfied about waiter work speed :| ");
        } else {
            player.opinion += 2;
            System.out.println("Player: " + player.name + " was so happy because the waiter worked very fast :) ");
        }
    }

    public void greeting(){
        System.out.println("Cook: " + waiter.name + ". Give me the order.");
        if(waiter.polite < 3){
            System.out.println("Cook: Why are you so slow ?!");
        }
        player.speak();
    }

    public void speak(){
        System.out.println("Cook: Thanks " + waiter.name + ". I'll call you when everything will be ready.");
        int phrase = random.nextInt(phrases.length);
        System.out.println("Cook: " + phrases[phrase] +
                           "\nCook: My random thought are disturbing me.");
    }

    public void goodBye(){
        if(waiter.polite == 1){
            System.out.println("Cook: " + waiter.name + " you're working so slow. " +
                               "Now everything is cold. I need to redo the order! ");
            waiter.goodBye();
            setMealNr();
            setReputation(-2);
        }
        if(waiter.polite == 2){
            System.out.println("Cook: " + waiter.name + " you're working so slow.");
            setReputation(-1);
        }
        else {
            System.out.println("Cook: " + waiter.name + " you're just in time.");
            setReputation(1);
        }
    }

    public void cooking(){
        player.setFood(meal.getFood());
        player.setSupply(meal.getSupply());
        player.setMeal(player.getFood() + " with " + player.getSupply());
        System.out.println("Player: " + player.name + " received " + player.getMeal() + ".");
        System.out.println("Admin: Now table " + (table.getNumber() + 1) + " is dirty. " +
                           "Where is the cleaner ?");
    }
}
