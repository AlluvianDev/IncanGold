public class Gold extends Treasure {
    private int amount = 45;

    public Gold(String name, int value) {
        super(name, value);
    }


    @Override
    public String toString() {
        return "Gold value: " + getValue() + ", Amount: " + amount;
    }
}
