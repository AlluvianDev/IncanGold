public class QuestCard {
    private String name;

    public QuestCard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Quest Card: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuestCard questCard = (QuestCard) obj;
        return name.equals(questCard.name);
    }
}