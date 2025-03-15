import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private final TreasureBox treasurebox = new TreasureBox();
    private final HazardBox hazardbox = new HazardBox();
    private final Player player = new Player();
    private int numberOfRounds = 5;
    //private Player player;
    private Box box;
    private Chest chest;
    private int currentRound = 1;

    public Game(){
        this.box = new Box();
        box.initializeBox();
    }
    public void initializeGameComponents() {

    }

    public void claimTreasures(TreasureBox treasureBox) {
        //if player wins, add money values of treasures to player balance
        for (int i = 0; i < treasurebox.getCurrentSize(); i++){
             TreasureCard currentCard = (TreasureCard) treasurebox.toArray()[i];
            System.out.println(currentCard);
        }
    }

    public void sortCardsIntoBoxes(QuestCard card){
        if (card instanceof TreasureCard){
            treasurebox.addToTreasureBox(card);
        }
        else if (card instanceof HazardCard){
            hazardbox.addToHazardBox(card);
        }
        else {
            System.out.println("An error occurred in Game.java .");
        }
    }
    public void displayBoxes() {
        System.out.println("TreasureBox contains:");
        treasurebox.displayItems(); //

        System.out.println("HazardBox contains:");
        hazardbox.displayItems();
    }

    public QuestCard processRoll(int roll){
        if (roll >= 0 && roll < 30) {
            QuestCard[] cards = box.getBox();
            return cards[roll];  // Return the card at the rolled index
        }
        return null;  // Return null if roll is invalid
    }

    public void play() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWould you like to roll the dice(press ENTER)?: ");
        scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            //System.out.println(Arrays.toString(box.getBox()));
            int roll = player.rollDice();
            QuestCard card = processRoll(roll);
            System.out.println("\nYou draw a " + card);
            TimeUnit.MILLISECONDS.sleep(1000);
            sortCardsIntoBoxes(card);

        }
        System.out.printf("\nRound %d is complete!",currentRound);
        currentRound += 1;
        if (currentRound > numberOfRounds){ //game over. calculate
            System.out.println("\nThe game has ended. Calculating score...");

            int treasureCount = treasurebox.getCurrentSize();
            int hazardCount = hazardbox.getCurrentSize();

            displayBoxes(); // display both boxes
            //treasurebox.clear();
            //hazardbox.clear();
            if (hazardCount > treasureCount){
                System.out.println("You died and lost all your loot!");
            }
            else{
                claimTreasures(treasurebox);
            }
        }
    }


    }



