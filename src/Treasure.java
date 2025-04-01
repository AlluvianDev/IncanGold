public class Treasure {
    private int value;
    private String type;

    public Treasure(String name,int value) {
        this.type = name;
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + "\nTreasure value: " + value;
    }
}
