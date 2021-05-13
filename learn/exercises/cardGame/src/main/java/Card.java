public class Card {
    private CardName name;
    private CardSuit suit;

    public enum CardSuit{
        SPADES, DIAMONDS, HEARTS, CLUBS;
    }
    public enum CardName{
        ACE(10),ONE(1),TWO(2),       THREE(3),
        FOUR(4), FIVE(5), SIX(6),SEVEN(7),EIGHT(8),
        NINE(9), JACK(10), QUEEN(10), KING(10);
        private final int value;
        CardName(int value){
            this.value =value;
        }
        public int getValue(){
            return this.value;
        }
    }

    public Card(CardName name, CardSuit suit) {
        this.name = name;
        this.suit = suit;
    }

    public CardName getName() {
        return name;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return name +":"+suit;
    }
}
