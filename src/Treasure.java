public class Treasure {
    private int value;

    public Treasure(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Treasure value: " + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Treasure treasure = (Treasure) obj;
        return value == treasure.value;
    }
}