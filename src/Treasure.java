public class Treasure {
    private int value;
    private String type;

    public Treasure(String name,int value) {
        this.value = value;
        this.type = name;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return type + "\nTreasure value: " + value;
    }
}
