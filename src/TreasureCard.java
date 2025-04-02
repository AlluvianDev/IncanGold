public class TreasureCard extends QuestCard {
    private Treasure treasure;
    private int value;

    public TreasureCard(Treasure treasure, int quantity) {
        this.treasure = treasure;
        this.value = quantity;
    }
    public int getTreasureQuantity() {
        return value;
    }
    public Treasure getTreasure(){
        return treasure;
    }

    @Override
    public String toString() {
        return treasure.getClass().getSimpleName() + " | Value: " + value;
    }
}
