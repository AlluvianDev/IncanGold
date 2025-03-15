public class Box extends Bag<QuestCard>{

    public Box(){
        QuestCard[] cards = (QuestCard[]) new Object[30];
    }

    public void initializeBox(){

        System.out.println("Box initialized");
    }
}
