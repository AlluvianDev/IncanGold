import java.util.Random;

public class Box extends Bag<QuestCard>{

    public Box() {
        super(QuestCard.class);
    }
    public void initializeBox(){

        // Add 15 TreasureCard's
         for (int i = 0; i < 15; i++){
             add(new TreasureCard("TreasureCard"));
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
