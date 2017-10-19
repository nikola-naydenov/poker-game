package poker.game.core.exception;

public class NotEnoughCardsException extends RuntimeException {
    public NotEnoughCardsException(final String message) {
        super(message);
    }
}
