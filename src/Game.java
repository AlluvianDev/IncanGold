public class Game {
    private int numberOfRounds;
    private Player player;
    private Box box;
    private Chest chest;

    public Game(int numberOfRounds, String playerName) {
        this.numberOfRounds = numberOfRounds;
        this.player = new Player(playerName);
        this.box = new Box();
        this.chest = new Chest();
    }

    public void initializeGameComponents() {
        box.initializeBox();
        chest.initializeChest();
    }

    public void claimTreasures(TreasureBox treasureBox) {
        while (!treasureBox.isEmpty()) {
            QuestCard card = treasureBox.remove();
            if (card instanceof TreasureCard) {
                TreasureCard treasureCard = (TreasureCard) card;
                Treasure treasureType = treasureCard.getTreasure();
                int amount = treasureCard.getAmount();

                for (int i = 0; i < amount; i++) {
                    if (treasureType instanceof Turquoise) {
                        if (chest.contains(new Turquoise())) {
                            chest.remove(new Turquoise());
                            player.getTent().add(new Turquoise());
                        }
                    } else if (treasureType instanceof Obsidian) {
                        if (chest.contains(new Obsidian())) {
                            chest.remove(new Obsidian());
                            player.getTent().add(new Obsidian());
                        }
                    } else if (treasureType instanceof Gold) {
                        if (chest.contains(new Gold())) {
                            chest.remove(new Gold());
                            player.getTent().add(new Gold());
                        }
                    }
                }
            }
        }
        player.calculateScore();
    }

    public void play() {
        System.out.println("Starting Incan Gold game with " + numberOfRounds + " rounds...");
        initializeGameComponents();

        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("\n=== Round " + round + " ===");

            // Draw 3 cards in each round
            for (int i = 0; i < 3; i++) {
                int index = player.rollDice();
                QuestCard drawnCard = box.removeByIndex(index);

                // Check if we've run out of cards
                if (drawnCard == null) {
                    System.out.println("No more cards in the box!");
                    continue;
                }

                System.out.println("Drew: " + drawnCard);

                if (drawnCard instanceof HazardCard) {
                    player.getHazardBox().add(drawnCard);
                    System.out.println("Added to HazardBox!");
                } else if (drawnCard instanceof TreasureCard) {
                    player.getTreasureBox().add(drawnCard);
                    System.out.println("Added to TreasureBox!");
                }
            }
        }

        // Game end
        System.out.println("\n=== Game Over ===");
        System.out.println("HazardBox size: " + player.getHazardBox().getCurrentSize());
        System.out.println("TreasureBox size: " + player.getTreasureBox().getCurrentSize());

        if (player.getHazardBox().getCurrentSize() > player.getTreasureBox().getCurrentSize()) {
            System.out.println("Player loses! More hazards than treasures.");
        } else {
            System.out.println("Player wins! Claiming treasures...");
            claimTreasures(player.getTreasureBox());
            System.out.println("Final score: " + player.getScore());
        }
    }
}