package poker.game.core.hands;

import poker.game.core.util.CardUtil;
import poker.game.model.Card;
import poker.game.model.Rank;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum FiveCardHands implements CardHandsEnum {
    ONE_PAIR("One Pair",
            cardList -> CardUtil.OF_A_KIND.test(2, cardList)),
    TWO_PAIR("Two Pair",
            cardList -> {
                List<Card> currentSet = cardList;
                int firstSize = currentSet.size();
                boolean aPair = false;
                while (currentSet.size() >= 2) {
                    final Card aCard = currentSet.get(0);
                    currentSet = currentSet.stream()
                            .filter(card -> !(card.getRank().compareTo(aCard.getRank()) == 0))
                            .collect(Collectors.toList());
                    if (firstSize - currentSet.size() == 2) {
                        if (aPair) return true;
                        else aPair = true;
                    }
                    firstSize = currentSet.size();
                }
                return false;
            }),
    THREE_OF_A_KIND("Three of a Kind",
            cardList -> CardUtil.OF_A_KIND.test(3, cardList)),
    STRAIGHT("Straight",
            cardList -> CardUtil.REDUCE_TO_BOOLEAN.test(
                    (card1, card2) -> (card1.getRank().compareTo(card2.getRank()) == -1),
                    cardList)),
    FLUSH("Flush",
            cardList -> {
                final Card aCard = cardList.get(0);
                return cardList.stream().allMatch(card -> card.getSuite().equals(aCard.getSuite()));
            }),
    FULL_HOUSE("Straight Flush",
            cardList -> CardUtil.OF_A_KIND.test(3, cardList)
                    && CardUtil.OF_A_KIND.test(2, cardList)),
    FOUR_OF_A_KIND("Four of a Kind",
            cardList -> CardUtil.OF_A_KIND.test(4, cardList)),
    STRAIGHT_FLUSH("Straight Flush",
            cardList -> CardUtil.REDUCE_TO_BOOLEAN.test(
                    (card1, card2) -> (card1.getSuite() == card2.getSuite()
                            && card1.getRank().compareTo(card2.getRank()) == -1),
                    cardList)),
    ROYAL_FLUSH("Royal Flush",
            cardList -> CardUtil.REDUCE_TO_BOOLEAN.test(
                    (card1, card2) -> (card1.getSuite() == card2.getSuite()
                    && card1.getRank().compareTo(card2.getRank()) == -1
                    && card1.getRank().compareTo(Rank.Nine) > 0),
                    cardList));

    private final Predicate<List<Card>> matches;
    private final String name;

    FiveCardHands(final String name,
                  final Predicate<List<Card>> matches) {
        this.matches = matches;
        this.name = name;
    }

    public boolean matches(final List<Card> cardList) {
        if (cardList.size() != 5) return false;
        Collections.sort(cardList);
        return matches.test(cardList);
    }

    @Override
    public String toString() {
        return name;
    }
}
