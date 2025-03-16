import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        boolean gameLoop = true;
        System.out.println("Welcome to Incan Gold.");
        while (gameLoop)
        {
            game.initializeGameComponents();
            for (int i = 0; i < 5; i++)
            {
                game.play();
            }
            if (!game.playAgain()){
                gameLoop = false;
                //calculate score.
                game.endGame();
            }
        }
    }
}
