import java.util.HashSet;
import java.util.Set;

public class Player {
    private final String playerName;
    private Set<Card> cards;
    public Player(String playerName) {
        this.playerName = playerName;
        cards = new HashSet();
    }

    public String getPlayerName() {
        return playerName;
    }

    public Set getCards() {
        return cards;
    }

    public void setCards(Set cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", cards=" + cards +
                '}';
    }
}
