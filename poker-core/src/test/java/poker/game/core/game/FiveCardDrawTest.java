package poker.game.core.game;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import poker.game.core.hands.FiveCardHands;
import poker.game.model.Card;
import poker.game.model.Rank;
import poker.game.model.Suite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiveCardDrawTest {

    private PokerGame game;

    @Before
    public void setUp() {
        game = new FiveCardDraw();
    }

    @Test
    public void dealAHand() throws Exception {
        List<Card> hand = game.dealAHand();
        assertTrue(hand.size() == 5);
    }

    @Test
    public void shuffleDeck() throws Exception {
        final PokerGame game2 = new FiveCardDraw();
        List<Card> hand = game.dealAHand();
        List<Card> hand2 = game2.dealAHand();
        assertEquals(hand, hand2);

        game2.shuffleDeck();
        hand = game.dealAHand();
        hand2 = game2.dealAHand();

        assertNotEquals(hand, hand2);
    }

    @Test
    public void evaluateHand() throws Exception {
        List<Card> royalFlush = new ArrayList<>();
        royalFlush.add(new Card(Rank.Ace, Suite.Clubs));
        royalFlush.add(new Card(Rank.Ten, Suite.Clubs));
        royalFlush.add(new Card(Rank.King, Suite.Clubs));
        royalFlush.add(new Card(Rank.Queen, Suite.Clubs));
        royalFlush.add(new Card(Rank.Jack, Suite.Clubs));

        assertEquals(game.evaluateHand(royalFlush),
                FiveCardHands.ROYAL_FLUSH.toString());

        List<Card> straightFlush = new ArrayList<>();
        straightFlush.add(new Card(Rank.Nine, Suite.Clubs));
        straightFlush.add(new Card(Rank.Ten, Suite.Clubs));
        straightFlush.add(new Card(Rank.King, Suite.Clubs));
        straightFlush.add(new Card(Rank.Queen, Suite.Clubs));
        straightFlush.add(new Card(Rank.Jack, Suite.Clubs));

        assertEquals(game.evaluateHand(straightFlush),
                FiveCardHands.STRAIGHT_FLUSH.toString());

        List<Card> fourOfAKind = new ArrayList<>();
        fourOfAKind.add(new Card(Rank.Nine, Suite.Clubs));
        fourOfAKind.add(new Card(Rank.Ten, Suite.Clubs));
        fourOfAKind.add(new Card(Rank.Nine, Suite.Diamonds));
        fourOfAKind.add(new Card(Rank.Nine, Suite.Hearts));
        fourOfAKind.add(new Card(Rank.Nine, Suite.Spades));

        assertEquals(game.evaluateHand(fourOfAKind),
                FiveCardHands.FOUR_OF_A_KIND.toString());

        List<Card> fullHouse = new ArrayList<>();
        fullHouse.add(new Card(Rank.Nine, Suite.Clubs));
        fullHouse.add(new Card(Rank.Nine, Suite.Hearts));
        fullHouse.add(new Card(Rank.Nine, Suite.Diamonds));
        fullHouse.add(new Card(Rank.Ten, Suite.Hearts));
        fullHouse.add(new Card(Rank.Ten, Suite.Spades));

        assertEquals(game.evaluateHand(fullHouse),
                FiveCardHands.FULL_HOUSE.toString());

        List<Card> flush = new ArrayList<>();
        flush.add(new Card(Rank.Nine, Suite.Clubs));
        flush.add(new Card(Rank.Jack, Suite.Clubs));
        flush.add(new Card(Rank.Two, Suite.Clubs));
        flush.add(new Card(Rank.Three, Suite.Clubs));
        flush.add(new Card(Rank.Ten, Suite.Clubs));

        assertEquals(game.evaluateHand(flush),
                FiveCardHands.FLUSH.toString());

        List<Card> straight = new ArrayList<>();
        straight.add(new Card(Rank.Nine, Suite.Clubs));
        straight.add(new Card(Rank.Ten, Suite.Hearts));
        straight.add(new Card(Rank.King, Suite.Diamonds));
        straight.add(new Card(Rank.Queen, Suite.Hearts));
        straight.add(new Card(Rank.Jack, Suite.Spades));

        assertEquals(game.evaluateHand(straight),
                FiveCardHands.STRAIGHT.toString());

        List<Card> threeOfAKind = new ArrayList<>();
        threeOfAKind.add(new Card(Rank.Nine, Suite.Clubs));
        threeOfAKind.add(new Card(Rank.Nine, Suite.Hearts));
        threeOfAKind.add(new Card(Rank.Nine, Suite.Diamonds));
        threeOfAKind.add(new Card(Rank.Queen, Suite.Hearts));
        threeOfAKind.add(new Card(Rank.Jack, Suite.Spades));

        assertEquals(game.evaluateHand(threeOfAKind),
                FiveCardHands.THREE_OF_A_KIND.toString());

        List<Card> twoPair = new ArrayList<>();
        twoPair.add(new Card(Rank.Nine, Suite.Clubs));
        twoPair.add(new Card(Rank.Nine, Suite.Hearts));
        twoPair.add(new Card(Rank.Queen, Suite.Diamonds));
        twoPair.add(new Card(Rank.Queen, Suite.Hearts));
        twoPair.add(new Card(Rank.Jack, Suite.Spades));

        assertEquals(game.evaluateHand(twoPair),
                FiveCardHands.TWO_PAIR.toString());

        List<Card> onePair = new ArrayList<>();
        onePair.add(new Card(Rank.Nine, Suite.Clubs));
        onePair.add(new Card(Rank.Nine, Suite.Hearts));
        onePair.add(new Card(Rank.King, Suite.Diamonds));
        onePair.add(new Card(Rank.Queen, Suite.Hearts));
        onePair.add(new Card(Rank.Jack, Suite.Spades));

        assertEquals(game.evaluateHand(onePair),
                FiveCardHands.ONE_PAIR.toString());

        List<Card> randomStuff = new ArrayList<>();
        randomStuff.add(new Card(Rank.Two, Suite.Clubs));
        randomStuff.add(new Card(Rank.Nine, Suite.Spades));
        randomStuff.add(new Card(Rank.King, Suite.Spades));
        randomStuff.add(new Card(Rank.Queen, Suite.Spades));
        randomStuff.add(new Card(Rank.Three, Suite.Spades));

        assertEquals(game.evaluateHand(randomStuff),
                "High Cards");
    }

}