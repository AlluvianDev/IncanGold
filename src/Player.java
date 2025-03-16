import java.util.Random;
import java.util.Scanner;

public class Player {
    private Tent tent;
    private TreasureBox treasureBox;
    private HazardBox hazardBox;
    private String name;
    private int score = 0;

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
        for (int i = 0; i < tent.getCurrentSize(); i++){
                Treasure treasure = (Treasure) tent.toArray()[i];
                if(treasure.getType().equals("Turquoise"))
                {
                    score += treasure.getValue(); // *1
                }
                else if (treasure.getType().equals("Obsidian"))
                {
                    score += treasure.getValue() * 5;
                }
                else if(treasure.getType().equals("Gold"))
                {
                    score += treasure.getValue() * 10;
                }
                else
                {
                    System.out.println("Unknown type of treasure owned.");
                }

        }
        return score;
    }
    public void setName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name, player?: ");
        this.name = scanner.nextLine();
    }
    public String toString() {
        return "Player: " + name + " | Score: " + score;
    }

}
