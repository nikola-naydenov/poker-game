package poker.game.model;

/**
 * Models a playing Card
 */
public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suite suite;

    public Card(final Rank rank, final Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Rank getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }


    @Override
    public boolean equals(Object that) {
        return that instanceof Card
                && this.rank.compareTo(((Card) that).rank) == 0
                && this.suite.compareTo(((Card) that).suite) == 0;
    }

    @Override
    public String toString() {
        return rank.getSymbol() + suite.getSymbol();
    }

    @Override
    public int hashCode() {
        return 1 + 31
                * rank.hashCode()
                * suite.hashCode();
    }

    public int compareTo(final Card that) {
        return this.rank.compareTo(that.rank);
    }
}
