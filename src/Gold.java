public class Gold extends Treasure {
    private int amount = 45;

    public Gold() {
        super(10); // Call Treasure's constructor and set value to 10
    }

    @Override
    public String toString() {
        return "Gold value: " + getValue() + ", Amount: " + amount;
    }
}
