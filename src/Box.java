public class Box extends Bag<QuestCard> {

    public Box() {
        super(QuestCard.class);
    }

    public void initializeBox() {
        Treasure Turquoise = new Turquoise();
        Treasure Gold = new Gold();
        Treasure Obsidian = new Obsidian();

        // Add 5 Turquoise
        int[] turquoiseQuantities = {33, 36, 39, 42, 45};
        for (int quantity : turquoiseQuantities) {
            add(new TreasureCard(Turquoise, quantity));
        }

        int[] obsidianQuantities = {18, 21, 24, 27, 30};
        for (int quantity : obsidianQuantities) {
            add(new TreasureCard(Obsidian, quantity));
        }

        int[] goldQuantities = {3, 6, 9, 12, 15};
        for (int quantity : goldQuantities) {
            add(new TreasureCard(Gold, quantity));
        }

        for (int i = 0; i < 3; i++) {
            add(new Spider());
            add(new Mummy());
            add(new Fire());
            add(new Goblin());
            add(new Snake());
        }
    }

    public QuestCard[] getBox() {
        return toArray();
    }
}
