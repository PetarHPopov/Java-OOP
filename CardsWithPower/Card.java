package CardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public  int calculate(Rank rank, Suit suit) {
        return rank.getRankPower() + suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank,
                this.suit,
                calculate(this.rank ,this.suit));
    }
}
