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
        this.score = 0;
    }
    public TreasureBox getTreasureBox() {
        return treasureBox;
    }

    public HazardBox getHazardBox() {
        return hazardBox;
    }

    public void setTent(Tent tent) {
        this.tent = tent;
    }

    public int rollDice() {
        RolledDice diceLog = new RolledDice();
        Random dice = new Random(); //Make an array to log dice rolls.
        int roll ;
        System.out.println("Rolling dice..."); //Add delay of 1-2 seconds after rolling
        roll = dice.nextInt(0,30);
        System.out.printf("You rolled %d",roll + 1);
        diceLog.add(roll + 1); // for player to see not indexing but real dice values.
        //TimeUnit.MILLISECONDS.sleep(1500); //1.5 seconds of sleep
        return roll;
    }

    public int calculateScore() {
        score = 0; // Reset score before calculating
        for (int i = 0; i < tent.getCurrentSize(); i++) {
            Treasure treasure = tent.get(i);
            // The value is already set correctly in the Treasure object
            score += treasure.getValue(); 
        }
        return score;
    }

    
    public String toString() {
        return "Player: " + name + " | Score: " + score;
    }

}
