import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameApp {
    public static void main(String[] args) throws InterruptedException {
        QuestCard questcard = new QuestCard();
        Game game = new Game();
        Box box = new Box();
        Scanner scanner = new Scanner(System.in);
        String playerKeyPress;
        String drawnCard;
        boolean gameLoop = true;

        box.initializeBox();
        while (gameLoop){
            System.out.print("Welcome to Incan Black. Would you like to roll the dice(press ENTER)?: ");
            playerKeyPress = scanner.nextLine();

            //drawing /- need 3 times per round
            int roll = game.roll();
            game.processRoll(roll);
            System.out.printf("");

            if (drawnCard.equals("TreasureCard"))
            {

            }
            else //HazardCard
            {

            }

            drawnCard = questcard.HazardOrTreasure(game.roll()); //
            System.out.printf("You draw a %s!",drawnCard);

            drawnCard = questcard.HazardOrTreasure(game.roll()); //
            System.out.printf("You draw a %s!",drawnCard);

            System.out.println("Round 1 is complete!");

        }