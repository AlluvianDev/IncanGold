public class GameApp {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        System.out.println("Welcome to Incan Black.");
        for (int i = 0; i < 5; i++){
            game.play();
        }
    }
}