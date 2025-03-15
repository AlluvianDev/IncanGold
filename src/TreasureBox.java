public class TreasureBox extends Bag<QuestCard>{
    QuestCard[] treasureBox = new QuestCard[15];

    public TreasureBox(){
        super(QuestCard.class);
    }

    public void addToTreasureBox(QuestCard card){
        add(card);
    }
}
