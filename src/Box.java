import java.util.Random;

public class Box extends Bag<QuestCard>{
    QuestCard[] box = new QuestCard[30];
    Random random = new Random();

    public void initializeBox(){

        // Add 15 TreasureCards
        for (int i = 0; i < 15; i++) {
            box[i] = new TreasureCard("TreasureCard");
        }
        // Add 15 HazardCards
        for (int i = 15; i < 30; i++) {
            box[i] = new HazardCard("HazardCard");
        }

        System.out.println("Box initialized");
    }
    public QuestCard[] getBox() {
        return box;
    }



}
