package poker.game.core.util;

import poker.game.model.Card;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public final class CardUtil {

    private CardUtil() { }

    /**
     * There are this many cards of a kind in the list
     * i.e if you want 2 of a kind, unless there is exactly two cards (and no more) of the
     * same rank in the list the result will be false
     */
    public static final BiPredicate<Integer, List<Card>> OF_A_KIND =
            (ofAKind, cardList) -> {
                List<Card> currentSet = cardList;
                int firstSize = currentSet.size();
                while (currentSet.size() >= ofAKind) {
                    final Card aCard = currentSet.get(0);
                    currentSet = currentSet.stream()
                            .filter(card -> !(card.getRank().compareTo(aCard.getRank()) == 0))
                            .collect(Collectors.toList());
                    if (firstSize - currentSet.size() == ofAKind) return true;
                    firstSize = currentSet.size();
                }
                return false;
            };

    /**
     * For each card in the list of cards, the BiPredicate matches current and the next card
     */
    public static final BiPredicate<BiPredicate<Card, Card>, List<Card>> REDUCE_TO_BOOLEAN =
            (predicate, cardList) -> {
                Card currentCard = cardList.get(0);
                boolean stillTrue = true;
                for (int i = 1; i < cardList.size(); i++) {
                    final Card nextCard = cardList.get(i);
                    if (!predicate.test(currentCard, nextCard)) {
                        stillTrue = false;
                        break;
                    }
                    currentCard = nextCard;
                }
                return stillTrue;
            };
}
