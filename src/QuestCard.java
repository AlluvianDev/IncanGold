public class QuestCard {
    private String name; //HazardCard or TreasureCard
    //public boolean equals(Object obj){} bunu kullan!!!!!!!!!!!!!!

    //odd numbers = HazardCard
    //even numbers = TreasureCard

    public QuestCard(String name){
        this.name = name;
    }
    public String HazardOrTreasure(int roll){
        if (roll % 2 == 0){//if even
            name = "TreasureCard";
        }
        else{
            name = "HazardCard";
        }
        return name;
    }









    /*public String toString(){
        String string = "";
        for(int i = 0; i < size ; i++){
            string +=
        }
    }*/
}
