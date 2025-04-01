public class QuestCard {
    private String name; //HazardCard or TreasureCard

    @Override
    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }
}
