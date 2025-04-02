public class Box extends Bag<QuestCard> {
    public void initializeBox() {
        // Adding 3 of each hazard type (15 total)
        for (int i = 0; i < 3; i++) {
            this.add(new Spider());
            this.add(new Mummy());
            this.add(new Snake());
            this.add(new Fire());
            this.add(new Goblin());
        }

        // Adding Turquoise TreasureCards (5 total)
        int[] turquoiseAmounts = {33, 36, 39, 42, 45};
        for (int amount : turquoiseAmounts) {
            this.add(new TreasureCard("Turquoise", new Turquoise(), amount));
        }

        // Adding Obsidian TreasureCards (5 total)
        int[] obsidianAmounts = {18, 21, 24, 27, 30};
        for (int amount : obsidianAmounts) {
            this.add(new TreasureCard("Obsidian", new Obsidian(), amount));
        }

        // Adding Gold TreasureCards (5 total)
        int[] goldAmounts = {3, 6, 9, 12, 15};
        for (int amount : goldAmounts) {
            this.add(new TreasureCard("Gold", new Gold(), amount));
        }
    }
}