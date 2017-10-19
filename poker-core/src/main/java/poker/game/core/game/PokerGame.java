package poker.game.core.game;

import poker.game.core.exception.NotEnoughCardsException;
import poker.game.model.Card;

import java.util.List;

/**
 * Models the basic functions of a poker game
 * Rules and functions differ for different implementations
 */
public interface PokerGame {

    /**
     * Deal a hand from the deck
     * the cards will be removed from the deck
     *
     * @return a List(hand) of cards
     * @throws NotEnoughCardsException
     */
    List<Card> dealAHand() throws NotEnoughCardsException;

    /**
     * Shuffle the current deck
     */
    void shuffleDeck();

    /**
     * Return the highest power hand matching the given card list
     * @param cards The cards to match
     * @return The name of the hand that matches
     */
    String evaluateHand(List<Card> cards);
}
