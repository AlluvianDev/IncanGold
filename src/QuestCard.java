public class QuestCard {
    private String name; //HazardCard or TreasureCard
    //public boolean equals(Object obj){} bunu kullan!!!!!!!!!!!!!!

    public QuestCard(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
