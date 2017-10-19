package poker.game.model;

public enum Suite {

    Hearts("\u2665"),
    Spades("\u2660"),
    Diamonds("\u2666"),
    Clubs("\u2663");

    private final String symbol;

    Suite(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
