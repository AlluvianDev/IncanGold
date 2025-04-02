public class Chest extends Bag<Treasure>{
    public Chest() {
        super(Treasure.class);
    }

    public void initializeChest() {
        for (int i = 0; i < 195; i++) { //quantities
            add(new Turquoise());
        }
        for (int i = 0; i < 120; i++) { //quantities
            add(new Obsidian());
        }
        for (int i = 0; i < 45; i++) { //quantities
            add(new Gold());
        }
    }
}
