import java.util.Random;

public class Player {
    private Tent tent;
    private final TreasureBox treasureBox;
    private final HazardBox hazardBox;
    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
        this.treasureBox = new TreasureBox();
        this.hazardBox = new HazardBox();
        this.tent = new Tent();
    }
    public String getName(){
        return name;
    }
    public TreasureBox getTreasureBox() {
        return treasureBox;
    }

    public HazardBox getHazardBox() {
        return hazardBox;
    }

    public Tent getTent() {
        return tent;
    }

    public int rollDice() {
        Random dice = new Random();
        return dice.nextInt(30); // Zar atıyoruz, 0-29 arası
    }

    public int calculateScore() {
        int score = 0;
        tent.displayItems();
        for (int i = 0; i < tent.getCurrentSize(); i++) {
            Treasure treasure = tent.toArray()[i];
            if (treasure instanceof Turquoise) {
                score += treasure.getValue();
            } else if (treasure instanceof Obsidian) {
                score += treasure.getValue() * 5;
            } else if (treasure instanceof Gold) {
                score += treasure.getValue() * 10;
            }
        }
        return score;
    }

    public String toString() {
        return "Player: " + name + " | Score: " + score;
    }
}
