package poker.game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Models a simple deck with no restrictions
 *
 * In case we want to play a game with a huge deck
 * or no face cards or whatever
 */
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public Deck(final List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public void addCard(final Card card) {
        this.cards.add(card);
    }

    public Card drawCard() {
        if (cards.size() == 0) return null;
        return cards.remove(0);
    }

    public boolean containsCard(final Card card) {
        return this.cards.contains(card);
    }

    public int cardCount() {
        return cards.size();
    }

    @Override
    public String toString() {
        return "This is a Deck of " + cards.size() + " cards!";
    }

    @Override
    public int hashCode() {
        return 1 + 31
                * cards.hashCode();
    }
}
