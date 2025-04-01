public class Box extends Bag<QuestCard>{

    public Box() {
        super(QuestCard.class);
    }
    public void initializeBox(){
        Treasure Turquoise = new Turquoise();
        Treasure Gold = new Gold();
        Treasure Obsidian = new Obsidian();
        // Add 5 Turquoise
        int[] turquoiseValues = {33,36,39,42,45};
        for (int value: turquoiseValues) {
            add(new TreasureCard(Turquoise,value));
        }
        // Add 5 Obsidian
        int[] obsidianValues = {18,21,24,27,30};
        for (int value: obsidianValues) {
            add(new TreasureCard(Obsidian,value));
        }
        // Add 5 Gold
        int[] goldValues = {3,6,9,12,15};
        for (int value: goldValues) {
            add(new TreasureCard(Gold,value));
        }

        // Add 3 of each Hazard
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
