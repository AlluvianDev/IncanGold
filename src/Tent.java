import java.util.List;
public class Tent extends Bag<Treasure>{
    public Tent() {
        super(Treasure.class);

    }

    public String toString() {
        System.out.println("Tent contains:");
        displayItems();
        return "";
    }
}
