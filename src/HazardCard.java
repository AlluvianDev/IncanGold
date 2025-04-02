public class HazardCard extends QuestCard {
    public HazardCard(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Hazard Card: " + getName();
    }
}