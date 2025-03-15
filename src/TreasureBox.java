public class TreasureBox extends Bag<QuestCard>{
    QuestCard[] treasureCards = toArray();

    public TreasureBox(){
        super(QuestCard.class);
    }

    public void addToTreasureBox(QuestCard card){
        add(card);
    }

    public void displayItems(){
        int count = 0;
        System.out.println("Your Treasure Box:");
        for (QuestCard card : treasureCards){
            count += 1;
            System.out.println(card);
        }
        System.out.printf("You have %d treasure cards.",count);
    }

}
