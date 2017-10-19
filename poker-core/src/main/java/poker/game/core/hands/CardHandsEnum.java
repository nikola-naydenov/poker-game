package poker.game.core.hands;

import poker.game.model.Card;

import java.util.List;

public interface CardHandsEnum {
    boolean matches(final List<Card> cardList);
}
