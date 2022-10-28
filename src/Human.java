import java.util.Random;

abstract class Human extends SuperClass{
    public String[] names = {"Mary", "Petter", "Hary", "Ira",
                             "John", "Steven", "Natalia", "Calin",
                             "Nastia", "Alex", "Dumitru", "Inga"};

    public String[] phrases = {"Such a good day. Hope the week will be easy...",
                               "Maybe I should have a walk in the weekend...",
                               "I want to go home...",
                               "So hard to work with people...",
                               "I'm so hungry...",
                               "Today is so cloudy...",
                               "Maybe it's time to reed a book...",
                               "Oh, I'm so busy this week...",
                               "My salary is so small. Maybe I should find another work...",
                               "Music always makes me happy..."};

    public Random random = new Random();
    public String name = names[random.nextInt(names.length)];
    public int opinion = 3;

    abstract void greeting();
    abstract void speak();
    abstract void goodBye();
}
