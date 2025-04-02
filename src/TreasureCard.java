public class TreasureCard extends QuestCard {
    private Treasure treasure;
    private int amount;

    public TreasureCard(String name, Treasure treasure, int amount) {
        super(name);
        this.treasure = treasure;
        this.amount = amount;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Treasure Card: " + getName() + " - " + treasure + " - Amount: " + amount;
    }
}