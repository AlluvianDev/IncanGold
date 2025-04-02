import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);

        Game game = new Game(player);
        game.play();
    }
}
