import java.util.Random;

public class Box extends Bag<QuestCard>{

    public Box() {
        super(QuestCard.class);
    }
    public void initializeBox(){

        // Add 15 TreasureCards
        for (int i = 0; i < 15; i++) {
            add(new TreasureCard("TreasureCard"));
        }
        // Add 15 HazardCards
        for (int i = 15; i < 30; i++) {
            add(new HazardCard("HazardCard"));
        }

        System.out.println("Box initialized");
    }
    public QuestCard[] getBox() {
        return toArray();
    }


}
