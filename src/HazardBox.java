public class HazardBox extends Bag<QuestCard>{
        QuestCard[] hazardBox = new QuestCard[15];
        
        public HazardBox(){
            super(QuestCard.class);
        }

        public void addToHazardBox(QuestCard card){
            add(card);
        }
}
