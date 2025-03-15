import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameApp {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        String playerKeyPress;
        String drawnCard;
        boolean gameLoop = true;


        while (gameLoop){
            System.out.print("Welcome to Incan Black. Would you like to roll the dice(press ENTER)?: ");
            playerKeyPress = scanner.nextLine();

            //drawing /- need 3 times per round
            int roll = game.roll();
            QuestCard card = game.processRoll(roll);
            System.out.println("\nYou draw a " + card);
            //game.sortCardsIntoBoxes(card);


            System.out.println("Round 1 is complete!");

        }
    }
}