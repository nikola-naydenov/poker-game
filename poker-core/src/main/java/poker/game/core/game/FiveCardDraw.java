package poker.game.core.game;

import poker.game.core.exception.NotEnoughCardsException;
import poker.game.core.hands.FiveCardHands;
import poker.game.core.util.DeckUtil;
import poker.game.model.Card;
import poker.game.model.Deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of a PokerGame that uses 5 card hands
 * and a deck of 52 cards
 */
public class FiveCardDraw implements PokerGame {

    private Deck deck;

    public FiveCardDraw() {
        deck = DeckUtil.buildStandardDeck();
    }

    @Override
    public List<Card> dealAHand() throws NotEnoughCardsException {
        if (deck.cardCount() < 5) throw new NotEnoughCardsException("Deck has less than five cards");
        final List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.drawCard());
        }
        return hand;
    }

    @Override
    public void shuffleDeck() {
        deck = DeckUtil.shuffleDeck(deck);
    }

    @Override
    public String evaluateHand(List<Card> cards) {
        FiveCardHands[] allHands = FiveCardHands.values();
        Arrays.sort(allHands, Comparator.reverseOrder());
        final Optional<FiveCardHands> aMatch = Arrays.stream(allHands)
                .filter(fiveCardHands -> fiveCardHands.matches(cards))
                .findFirst();
        if (aMatch.isPresent()) return aMatch.get().toString();
        return "High Cards";
    }
}
