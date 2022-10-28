public class Waiter extends Human implements Action{

    private final Menu menu;
    private final Meal meal;
    private final Player player;
    public int bill;
    public int polite;

    public Waiter(Menu menu, Meal meal, Player player){
        this.menu = menu;
        this.meal = meal;
        this.player = player;
        this.polite = random.nextInt(3) + 1;
    }

    public void greeting(){
        switch (polite) {
            case 3 -> {
                System.out.println("Waiter: Good morning. " + player.name +
                        " My name is " + name + ". What do you want to order ?");
                player.opinion += 2;
                setReputation(2);
            }
            case 2 -> {
                System.out.println("Waiter: Hallo. What do you want to order ?");
                player.opinion++;
                setReputation(1);
            }
            case 1 -> {
                System.out.println("Waiter: Are you ready or not to make an order ?!");
                player.opinion--;
                setReputation(-2);
            }
        }
    }

    public void speak(){
        int phrase = random.nextInt(phrases.length);
        System.out.println("Waiter: " + phrases[phrase] + ".\nWaiter: I should stop talking to myself.");
    }

    public void goodBye(){
        if(polite == 1){
            System.out.println("Waiter: stop yelling at me !");
            setReputation(-2);
        }
    }

    public void takeOrder(){
        meal.pickFood();
        meal.stopListCheck();

        System.out.println("Player: " + player.name + " ordered "
                           + meal.getFood() + " with " + meal.getSupply() + ".");
        System.out.println("Waiter: Thanks " + player.name + ". Your order will be ready as soon as possible.");
    }

    public void bringBill(){
        menu.createFoodMenu();
        menu.createSuppMenu();
        int bill1 = menu.getFoodWithPrice().get(player.getFood());
        int bill2 = menu.getSuppliesWithPrice().get(player.getSupply());
        this.bill = bill1 + bill2;
        player.pay(bill);
        System.out.println("Waiter: Your bill, " + player.name
                           + ", is " + bill + " $");

        System.out.println("Player: Now balance of my card is: " + player.moneyAmount() + " $");
    }

    public void complaint() {
        System.out.println("Waiter: Sorry, " + player.name + " but our Book of Complaints is" +
                " not available at the moment. :)");
    }

    public void tip() {
        if(player.tips == 1){
            System.out.println("Waiter: " + player.name + ", thanks for the tip.");
            setReputation(1);
        }
        if(player.opinion < 6){
            complaint();
        }
    }
}
