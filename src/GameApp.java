public class GameApp {
    public static void main(String[] args) throws InterruptedException {

            Random dice = new Random(); //Make an array to log dice rolls.
            int roll1 = 0;
            int roll2 = 0;
            int roll3 = 0;
            //0-29 dice roll decides which Questcard will be pulled out. 15 hazardcards or 15 treasurecards.
            //if a treasurecard is pulled, in rounds 1-2-3-4-5, these many treasures will be in a chest and given to player.(Amount to be determined.)
            //Turquoise: 33, 36, 39, 42, 45 (1 card of each amount)
            //Obsidian: 18, 21, 24, 27, 30 (1 card of each amount)
            //Gold: 3, 6, 9, 12, 15 (1 card of each amount)
            //if a hazardcard is pulled,
            System.out.println("Rolling dice..."); //Add delay of 1-2 seconds after rolling
            roll1 = dice.nextInt(0,30);
            System.out.printf("You rolled %d",roll1);
            TimeUnit.MILLISECONDS.sleep(1500); //1.5 seconds of sleep

            System.out.println("Rolling dice..."); //Add delay of 1-2 seconds after rolling
            roll2 = dice.nextInt(0,30);
            System.out.printf("You rolled %d",roll2);
            TimeUnit.MILLISECONDS.sleep(1500); //1.5 seconds of sleep

            System.out.println("Rolling dice..."); //Add delay of 1-2 seconds after rolling
            roll3 = dice.nextInt(0,30);
            System.out.printf("You rolled %d",roll3);
            TimeUnit.MILLISECONDS.sleep(1500); //1.5 seconds of sleep

    }
}
