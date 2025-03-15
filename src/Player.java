import java.util.Random;

public class Player {
    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;
    private String name;
    private int score;

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
        return 0;
    }

    public String toString() {
        return null;
    }

}
