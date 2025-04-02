public class TreasureCard extends QuestCard {
    private Treasure treasure;
    private int value;

    public TreasureCard(Treasure treasure, int value) {
        this.treasure = treasure;
        this.value = value;
    }

    @Override
    public String toString() {
        return treasure.getClass().getSimpleName() + " | Value: " + value;
    }
}
