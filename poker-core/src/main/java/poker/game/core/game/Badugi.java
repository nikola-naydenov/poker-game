package poker.game.core.game;

import poker.game.core.exception.NotEnoughCardsException;
import poker.game.model.Card;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Badugi implements PokerGame {

    @Override
    public List<Card> dealAHand() throws NotEnoughCardsException {
        throw new NotImplementedException();
    }

    @Override
    public void shuffleDeck() {
        throw new NotImplementedException();
    }

    @Override
    public String evaluateHand(List<Card> cards) {
        throw new NotImplementedException();
    }
}
