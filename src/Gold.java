public class Gold extends Treasure {
    public Gold() {
        setValue(10);
    }

    @Override
    public String toString() {
        return "Gold (Value: " + getValue() + ")";
    }
}
