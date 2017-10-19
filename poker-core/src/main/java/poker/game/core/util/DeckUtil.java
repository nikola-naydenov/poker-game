package poker.game.core.util;

import poker.game.model.Card;
import poker.game.model.Deck;
import poker.game.model.Rank;
import poker.game.model.Suite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility Class for building decks
 * Not using the Builder pattern
 */
public final class DeckUtil {
    private DeckUtil() { }

    /**
     * Builds a deck with a card of each rank and suite
     * @return a Standard Deck
     */
    public static Deck buildStandardDeck() {
        final List<Card> cards = new ArrayList<>();
        for (final Rank rank : Rank.values()) {
            for (final Suite suite : Suite.values()) {
                cards.add(new Card(rank, suite));
            }
        }
        return new Deck(cards);
    }

    /**
     * Shuffle the deck using the standard Collections.shuffle
     * @param deck the Deck to shuffle
     * @return A shuffled Deck
     */
    public static Deck shuffleDeck(final Deck deck) {
        final List<Card> cards = deck.getCards();
        Collections.shuffle(cards);
        return new Deck(cards);
    }
}
