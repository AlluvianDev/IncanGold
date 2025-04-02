import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        Player player = new Player(username);
    
        Game game = new Game(player);
        
        boolean gameLoop = true;
        System.out.println("Welcome to Incan Gold.");
        
        while (gameLoop) {
            game.initializeGameComponents();
            
            // Each game consists of 5 rounds
            for (int i = 0; i < 5; i++) {
                game.play();
            }
            
            // Ask if the player wants to play again
            if (!game.playAgain()) {
                gameLoop = false;
                System.out.println("Thank you for playing Incan Gold!");
            }
        }
    }
}
