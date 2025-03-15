public class HazardBox extends Bag<QuestCard>{
        QuestCard[] hazardCards = toArray();
        
        public HazardBox(){
            super(QuestCard.class);
        }

        public void addToHazardBox(QuestCard card){
            add(card);
        }

        public void displayItems(){
            int count = 0;
            System.out.println("Your Hazard Box:");

            for (QuestCard card : hazardCards)
            {
                count += 1;
                System.out.println(card);
            }
            System.out.printf("You have %d hazard cards.",count);
        }

}
