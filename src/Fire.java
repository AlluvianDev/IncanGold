public class Fire extends HazardCard {
    public Fire(String name) {
        super(name);
    }
    
    @Override
    public void Attack() {
        System.out.println("You are attacked by flames!");
    }
    
    @Override
    public String toString() {
        return "Fire (Hazard)";
    }
}
