import java.util.Random;

public class Box extends Bag<QuestCard>{

    public Box() {
        super(QuestCard.class);
    }
    public void initializeBox(){

        // Add 15 TreasureCards
        // Add 5 Turqoise
        int[] turquoiseValues = {33,36,39,42,45};
        for (int value: turquoiseValues) {
            add(new TreasureCard("Turquoise",value));
        }
        // Add 5 Obsidian
        int[] obsidianValues = {18,21,24,27,30};
        for (int value: obsidianValues) {
            add(new TreasureCard("Obsidian",value));
        }
        // Add 5 Gold
        int[] goldValues = {3,6,9,12,15};
        for (int value: goldValues) {
            add(new TreasureCard("Gold",value));
        }
        // Add 15 HazardCards
        // Add 3 Spider
        for (int i = 0; i < 3; i++){
            add(new HazardCard("Spider"));
        }
        // Add 3 Mummy
        for (int i = 0; i < 3; i++){
            add(new HazardCard("Mummy"));
        }
        // Add 3 Fire
        for (int i = 0; i < 3; i++){
            add(new HazardCard("Fire"));
        }
        // Add 3 Goblin
        for (int i = 0; i < 3; i++){
            add(new HazardCard("Goblin"));
        }
        // Add 3 Snake
        for (int i = 0; i < 3; i++){
            add(new HazardCard("Snake"));
        }


        System.out.println("Box initialized");
    }
    public QuestCard[] getBox() {
        return toArray();
    }


}
