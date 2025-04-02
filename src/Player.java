public class Player {
    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.tent = new Tent();
        this.treasureBox = new TreasureBox();
        this.hazardBox = new HazardBox();
        this.score = 0;
    }

    public int rollDice() {
        return (int) (Math.random() * 30); // 0-29
    }

    public int calculateScore() {
        score = 0;
        Treasure[] treasures = tent.toArray();
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                score += treasure.getValue();
            }
        }
        return score;
    }

    public Tent getTent() {
        return tent;
    }

    public TreasureBox getTreasureBox() {
        return treasureBox;
    }

    public HazardBox getHazardBox() {
        return hazardBox;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player: " + name + ", Score: " + score;
    }
}