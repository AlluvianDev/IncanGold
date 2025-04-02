import java.util.Scanner;

public class Game {
    private int numberOfRounds;
    private Player player;
    private Box box;
    private Chest chest;

    public Game(Player player) {
        this.numberOfRounds = 5;
        this.player = player;
        this.box = new Box();
        this.chest = new Chest();
        initializeGameComponents();
    }

    public void initializeGameComponents() {
        box.initializeBox();
        chest.initializeChest();
    }

    public Box getBox() {
        return box;
    }

    /*public void claimTreasures(TreasureBox treasureBox) {
        while (!chest.isEmpty()) {
            Treasure treasure = (Treasure) ;
            player.getTent().add(treasure);
            chest.remove(treasure);


        }
    }*/

    public void claimTreasures(TreasureBox treasureBox){
        for (int i = 0; i < treasureBox.getCurrentSize(); i++) { //for each treasure card, give player a Treasure from Chest
            TreasureCard currentCard = (TreasureCard) treasureBox.toArray()[i];
            int value = currentCard.getValue();
            System.out.println("Treasure " + (i+1) + ": " + currentCard);
            switch (currentCard.getTreasure()) {
                case Turquoise turquoise -> {
                    for (; value > 0; value--) {
                        for (int j = 0; j < chest.getCurrentSize(); j++) {
                            if (chest.get(j) instanceof Turquoise) { //chest.get(j) = Turquoise
                                player.getTent().add(chest.get(j));
                                chest.remove(chest.get(j));
                                //j--; // Adjust index after removal
                            }
                        }
                    }
                }
                case Obsidian obsidian -> {
                    for (; value == 0; value--) {
                        for (int j = 0; j < chest.getCurrentSize(); j++) {
                            if (chest.get(j) instanceof Obsidian) {
                                player.getTent().add(chest.get(j));
                                chest.remove(chest.get(j));
                                //j--; // Adjust index after removal
                            }
                        }
                    }
                }
                case Gold gold -> {
                    for (; value == 0; value--) {
                        for (int j = 0; j < chest.getCurrentSize(); j++) {
                            if (chest.get(j) instanceof Gold) {
                                player.getTent().add(chest.get(j));
                                chest.remove(chest.get(j));
                                //j--; // Adjust index after removal
                            }
                        }
                    }
                }
                case null, default -> System.out.println("An error occurred.");
            }
        }
    }
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting the game...\n");

        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("Round " + round + " starts!\n");

            for (int i = 0; i < 3; i++) {
                System.out.println("Rolling dice...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int roll = player.rollDice();
                System.out.println("You rolled " + (roll + 1));

                Box box = getBox();
                QuestCard drawnCard = box.getBox()[roll];

                if (drawnCard instanceof HazardCard) {
                    System.out.println("Card drawn: Hazard Card - " + drawnCard);
                    player.getHazardBox().add(drawnCard);
                } else if (drawnCard instanceof TreasureCard) {
                    System.out.println("Card drawn: Treasure Card - " + drawnCard);
                    player.getTreasureBox().add(drawnCard);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



            System.out.println("\nPress Enter to start next round...");
            scanner.nextLine();
        }

        System.out.println("Game Over!");
        claimTreasures(player.getTreasureBox());
        System.out.println("Final Score: " + player.calculateScore());
        if (player.getHazardBox().getCurrentSize() > player.getTreasureBox().getCurrentSize()) {
            System.out.println("You lose the game " + player.getName() + "!");
        } else {
            System.out.println("You win the game " + player.getName() + "!");
        }
    }
}
