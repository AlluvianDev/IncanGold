import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game {
    private int numberOfRounds = 5;
    private Player player;
    private Box box;
    private Chest chest;

    public void initializeGameComponents() {

    }

    public void claimTreasures(TreasureBox treasureBox) {

    }


    public int roll() throws InterruptedException {
        RolledDice diceLog = new RolledDice();
        Random dice = new Random(); //Make an array to log dice rolls.
        int roll = 0;
        //0-29 dice roll decides which Questcard will be pulled out of Box. 15 hazardcards or 15 treasurecards.
        //if a treasurecard is pulled, in rounds 1-2-3-4-5, these many treasures will be in a chest and given to player.(Amount to be determined.)
        //Turquoise: 33, 36, 39, 42, 45 (1 card of each amount)
        //Obsidian: 18, 21, 24, 27, 30 (1 card of each amount)
        //Gold: 3, 6, 9, 12, 15 (1 card of each amount)
        //if a hazardcard is pulled,
        //
        System.out.println("Rolling dice..."); //Add delay of 1-2 seconds after rolling
        roll = dice.nextInt(0,30);
        System.out.printf("You rolled %d",roll + 1);
        diceLog.add(roll + 1); // for player to see not indexing but real dice values.
        TimeUnit.MILLISECONDS.sleep(1500); //1.5 seconds of sleep
        return roll;
    }

    public void play() {

    }
}
