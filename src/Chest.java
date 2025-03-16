public class Chest extends Bag<Treasure>{
    public Chest() {
        super(Treasure.class);
    }

    public void initializeChest() {

        // Add 5 Turqoise
        int[] turquoiseValues = {33,36,39,42,45};
        for (int value: turquoiseValues) {
            add(new Treasure("Turquoise",value));
        }
        // Add 5 Obsidian
        int[] obsidianValues = {18,21,24,27,30};
        for (int value: obsidianValues) {
            add(new Treasure("Obsidian",value));
        }
        // Add 5 Gold
        int[] goldValues = {3,6,9,12,15};
        for (int value: goldValues) {
            add(new Treasure("Gold",value));
        }
    }
}
