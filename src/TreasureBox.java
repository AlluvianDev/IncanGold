public class TreasureBox extends Bag<QuestCard>{
    QuestCard[] treasureCards = toArray();

    public TreasureBox(){
        super(QuestCard.class);
    }

    /*public void addToTreasureBox(QuestCard card){
        if (add(card)) {
            System.out.println(card + " added to TreasureBox.");
            System.out.println("TreasureBox now contains: " + getCurrentSize() + " items.\n");
        } else {
            System.out.println("TreasureBox is full.");
        }
    }*/

}
