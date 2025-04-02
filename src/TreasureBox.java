public class TreasureBox extends Bag<QuestCard>{
    QuestCard[] treasureCards = toArray();

    public TreasureBox(){
        super(QuestCard.class);
    }

}
