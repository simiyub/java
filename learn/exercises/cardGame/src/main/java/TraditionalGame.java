import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;


public class TraditionalGame implements Game{
    private boolean run;

    public static void main(String[] args) {
        TraditionalGame game = new TraditionalGame();
        game.run();
    }

    public void run() {
        Stack<Card> cards=cards();
        Set<Player>players = getPlayers();
        run = cards.size()==52 && players.size()>1;
        System.out.println(cards.size());
        players.forEach(System.out::println);
        players = dealCards(players,cards);

        while(running()){

        }
    }

    private Set<Player> dealCards(Set<Player> players, Stack<Card> cards) {
        int share = cards.size()/players.size();

        for(int i=0;i<=share;i++){
            for(Player player:players){
                player.getCards().add(cards.remove(i));
            }
        }
        System.out.println();
        return players;
    }

    private Set<Player> getPlayers() {
        Scanner userInterface = new Scanner(System.in);
        Set<Player> players = new HashSet<>();

        boolean add = true;

        while(add){
            System.out.println("Type the name of a player to be added to the game..");
            String playerName = userInterface.next();
            players.add(new Player(playerName));
            System.out.println("Do you want to add another player to this game? y/n");
            //String more = userInterface.next();
            //System.out.println(more);
            if (userInterface.next().equalsIgnoreCase("n") ){
                userInterface.close();
                add = false;
            }
        }
        return players;
    }

    public Stack<Card> cards() {
        Stack<Card> cards = new Stack<>();
        for(Card.CardName card: Card.CardName.values()) {
            for (Card.CardSuit suit : Card.CardSuit.values()) {
                cards.add(new Card(card,suit));
            }
        }
        return cards;
    }

    public Player winner() {
        throw new NotImplementedException();
    }

    public List<Player> players() {
        throw new NotImplementedException();
    }

    public Card topCard() {
        throw new NotImplementedException();
    }

    public Player currentPlayer() {
        throw new NotImplementedException();
    }

    public boolean running() {
        return run;
    }
}
