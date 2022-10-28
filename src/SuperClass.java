abstract class SuperClass {
    static int servicedPlayers = 0;
    static int deckNr = 0;
    static int cardNr = 0;
    static int mealNr = 0;
    static int menuNr = 0;
    static int playerNr = 0;
    static int reputation = 0;



    public static void setServicedPlayers() {
        servicedPlayers++;
    }

    public static void setDeckNr() {
        deckNr++;
    }

    public static void setCardNr() {
        cardNr++;
    }

    public static void setMealNr() {
        mealNr++;
    }
    public static void setPlayerNr() {
        playerNr++;
    }

    public static void setMenuNr() {
        menuNr++;
    }

    public static void setReputation(int reputation) {
        SuperClass.reputation += reputation;
    }
}
