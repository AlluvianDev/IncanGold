public class HazardBox extends Bag<QuestCard>{
        QuestCard[] hazardCards = toArray();
        
        public HazardBox(){
            super(QuestCard.class);
        }

        public void addToHazardBox(QuestCard card){
            if (add(card)) {
                System.out.println(card + " added to HazardBox.");
                System.out.println("HazardBox now contains: " + getCurrentSize() + " items.\n");
            } else {
                System.out.println("HazardBox is full.");
            }
        }
}
