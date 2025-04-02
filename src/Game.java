import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private final Player player;
    private final Random random = new Random();
    private int numberOfRounds = 5;
    private Tent tent;
    private Box box;
    private Chest chest;
    private int currentRound = 1;

    public Game(Player player) {
        this.player = player;
        this.tent = new Tent();
        this.box = new Box();
        this.chest = new Chest();

        player.setTent(tent);
    }

    public void initializeGameComponents() {
        box.initializeBox(); // DO NOT RE/MOVE THIS, TOTALLY BREAKS
        chest.initializeChest();
    }

    public void claimTreasures(TreasureBox treasurebox) throws InterruptedException {
        // Get the treasures from the chest
        for (int i = 0; i < treasurebox.getCurrentSize(); i++) { //for each treasure card, give player a Treasure from Chest
            TreasureCard currentCard = (TreasureCard) treasurebox.toArray()[i];
            int cardValue = currentCard.getValue();
            System.out.println("Treasure " + (i+1) + ": " + currentCard);
            
            switch (currentCard.getTreasure().getClass().getSimpleName()) {
                case "Turquoise" -> {
                    for (int k = 0; k < cardValue; k++) { // Loop for the number of treasures to add
                        for (int j = 0; j < chest.getCurrentSize(); j++) {
                            if (chest.get(j) instanceof Turquoise) {
                                tent.add(chest.get(j));
                                chest.remove(chest.get(j));
                                break; // Break after finding one Turquoise
                            }
                        }
                    }
                }
                case "Obsidian" -> {
                    for (int k = 0; k < cardValue; k++) { // Loop for the number of treasures to add
                        for (int j = 0; j < chest.getCurrentSize(); j++) {
                            if (chest.get(j) instanceof Obsidian) {
                                tent.add(chest.get(j));
                                chest.remove(chest.get(j));
                                break; // Break after finding one Obsidian
                            }
                        }
                    }
                }
                case "Gold" -> {
                    for (int k = 0; k < cardValue; k++) { // Loop for the number of treasures to add
                        for (int j = 0; j < chest.getCurrentSize(); j++) {
                            if (chest.get(j) instanceof Gold) {
                                tent.add(chest.get(j));
                                chest.remove(chest.get(j));
                                break; // Break after finding one Gold
                            }
                        }
                    }
                }
                default -> System.out.println("An error occurred.");
            }
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println("Items have been sent to your tent.\n");
        }
    
        // Display tent contents
        System.out.println(tent);
        System.out.println("This is the tent.");
        
        // Send tent to player
        player.setTent(tent);
    }

    public void sortCardsIntoBoxes(QuestCard card) {
        if (card instanceof TreasureCard) {
            player.getTreasureBox().add(card);
        } else if (card instanceof HazardCard) {
            player.getHazardBox().add(card);
        } else {
            System.out.println("An error occurred in Game.java .");
        }
    }

    public void displayBoxes() {
        System.out.println("\nTreasureBox contains:");
        player.getTreasureBox().displayItems(); //

        System.out.println("\nHazardBox contains:");
        player.getHazardBox().displayItems();
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
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("\nYou draw a " + card + "\n");
            TimeUnit.MILLISECONDS.sleep(1000);
            sortCardsIntoBoxes(card);

        }
        System.out.printf("\nRound %d is complete!", currentRound);
        currentRound++;
        if (currentRound > numberOfRounds) { //game over. calculate
            System.out.println("\nThe game has ended. Calculating score...");

            displayBoxes(); // display both boxes
            if ((player.getHazardBox().getCurrentSize() < player.getTreasureBox().getCurrentSize())) {
                claimTreasures(player.getTreasureBox());
            } else {
                System.out.println("You died and lost all your loot!");
                endGame();
            }
            player.getTreasureBox().clear();
            player.getHazardBox().clear();
            currentRound = 1;
        }
    }
}
