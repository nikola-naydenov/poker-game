package poker.game.model;


/**
 * Represents the Rank of cards listed in order of strength
 */
public enum Rank {
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Ten("10"),
    Jack("J"),
    Queen("Q"),
    King("K"),
    Ace("A");

    private final String symbol;

    Rank(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
