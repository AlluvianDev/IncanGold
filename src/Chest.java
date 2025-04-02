public class Chest extends Bag<Treasure> {
    public void initializeChest() {
        // Adding 195 Turquoise (value of 1)
        for (int i = 0; i < 195; i++) {
            this.add(new Turquoise());
        }

        // Adding 120 Obsidian (value of 5)
        for (int i = 0; i < 120; i++) {
            this.add(new Obsidian());
        }

        // Adding 45 Gold (value of 10)
        for (int i = 0; i < 45; i++) {
            this.add(new Gold());
        }
    }
}