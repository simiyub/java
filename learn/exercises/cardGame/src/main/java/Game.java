import java.util.List;
import java.util.Stack;

public interface Game {
    void run();
    Player winner();
    Stack cards();
    List<Player> players();
    Player currentPlayer();

    boolean running();

    Card topCard();
}
