import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    private final TreasureBox treasurebox = new TreasureBox();
    private final HazardBox hazardbox = new HazardBox();
    private final Player player = new Player();
    private final Random random = new Random();
    private int numberOfRounds = 5;
    private Tent tent;
    private Box box;
    private Chest chest;
    private int currentRound = 1;

    public Game() {
        this.tent = new Tent();
        this.box = new Box();
        this.chest = new Chest();
        player.setName();

        player.setTent(tent);
        //initializeGameComponents();

    }

    public void initializeGameComponents() {
        box.initializeBox(); // DO NOT RE/MOVE THIS, TOTALLY BREAKS
        chest.initializeChest();
    }

    public void claimTreasures(TreasureBox treasurebox) throws InterruptedException {
        Object[] treasureChestObjects = chest.toArray(); //toArray gives us Object[], we turn that into Treasure[] like this
        Treasure[] treasureChest = Arrays.copyOf(treasureChestObjects, treasureChestObjects.length, Treasure[].class);
        //if player wins, add money values of treasures to player balance
        for (int i = 0; i < treasurebox.getCurrentSize(); i++) { //for each treasurecard, give player a Treasure from Chest
            int treasureNumber = 0;
            TreasureCard currentCard = (TreasureCard) treasurebox.toArray()[i];
            System.out.println("\n" + currentCard + " #" + (i + 1) + " is drawn from your TreasureBox. ");
            System.out.println("Opening chest...");
            TimeUnit.MILLISECONDS.sleep(3000);
            treasureNumber = random.nextInt(15 - i); //decrement 15 each loop so we dont get indexoutofbounds exception

            Treasure playerLoot = treasureChest[treasureNumber];
            System.out.println("You get: " + playerLoot);

            //send to tent
            tent.add(playerLoot);
            System.out.println("Item has been sent to your tent.\n");

            chest.removeByIndex(treasureNumber); //remove the obtained treasure from chest

        }
        //after loop
        System.out.println(tent);

        //send tent to player
        player.setTent(tent);

        chest.clear();
        box.clear();
    }

    public void sortCardsIntoBoxes(QuestCard card) {
        if (card instanceof TreasureCard) {
            treasurebox.addToTreasureBox(card);
        } else if (card instanceof HazardCard) {
            hazardbox.addToHazardBox(card);
        } else {
            System.out.println("An error occurred in Game.java .");
        }
    }

    public void displayBoxes() {
        System.out.println("\nTreasureBox contains:");
        treasurebox.displayItems(); //

        System.out.println("\nHazardBox contains:");
        hazardbox.displayItems();
    }

    public QuestCard processRoll(int roll) {
        if (roll >= 0 && roll < 30) {
            QuestCard[] cards = box.getBox();
            return cards[roll];  // Return the card at the rolled index
        }
        return null;  // Return null if roll is invalid
    }

    public boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) { // Keep asking until a valid input is entered
            System.out.print("\nWould you like to play again? (yes/no): ");
            userInput = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            if (userInput.equalsIgnoreCase("yes")) {
                return true;
            } else if (userInput.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    public void endGame() {
        player.calculateScore();
        System.out.println(player);
    }

    public void play() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWould you like to roll the dice(press ENTER)?: ");
        scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            int roll = player.rollDice();
            QuestCard card = processRoll(roll);
            System.out.println("\nYou draw a " + card);
            TimeUnit.MILLISECONDS.sleep(1000);
            sortCardsIntoBoxes(card);

        }
        System.out.printf("\nRound %d is complete!", currentRound);
        currentRound++;
        if (currentRound > numberOfRounds) { //game over. calculate
            System.out.println("\nThe game has ended. Calculating score...");

            int treasureCount = treasurebox.getCurrentSize();
            int hazardCount = hazardbox.getCurrentSize();

            displayBoxes(); // display both boxes
            if (hazardCount > treasureCount) {
                claimTreasures(treasurebox);
                //System.out.println("You died and lost all your loot!");
            } else {
                claimTreasures(treasurebox);
            }
            treasurebox.clear();
            hazardbox.clear();
            currentRound = 1;
        }
    }
}