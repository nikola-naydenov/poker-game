package poker.game.core.hands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import poker.game.model.Card;
import poker.game.model.Rank;
import poker.game.model.Suite;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiveCardHandsTest {

    @Test
    public void when_GivenMoreOrLessThanFive_All_HandMatches_Return_False() {
        List<Card> moreHand = new ArrayList<>();
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));

        List<Card> lessHand = new ArrayList<>();
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));
        moreHand.add(new Card(Rank.Ace, Suite.Clubs));

        assertTrue(Arrays.stream(FiveCardHands.values())
                .noneMatch(fiveCardHands -> fiveCardHands.matches(moreHand)));

        assertTrue(Arrays.stream(FiveCardHands.values())
                .noneMatch(fiveCardHands -> fiveCardHands.matches(lessHand)));
    }

    @Test
    public void when_GivenARoyalFlush_RoyalFlushHand_Matches_Returns_True() {
        List<Card> royalFlush = new ArrayList<>();
        royalFlush.add(new Card(Rank.Ace, Suite.Clubs));
        royalFlush.add(new Card(Rank.Ten, Suite.Clubs));
        royalFlush.add(new Card(Rank.King, Suite.Clubs));
        royalFlush.add(new Card(Rank.Queen, Suite.Clubs));
        royalFlush.add(new Card(Rank.Jack, Suite.Clubs));

        assertTrue(firstMatchIs(FiveCardHands.ROYAL_FLUSH, royalFlush));
    }

    @Test
    public void when_GivenAStraightFlush_StraightFlushHand_Matches_Returns_True() {
        List<Card> straightFlush = new ArrayList<>();
        straightFlush.add(new Card(Rank.Nine, Suite.Clubs));
        straightFlush.add(new Card(Rank.Ten, Suite.Clubs));
        straightFlush.add(new Card(Rank.King, Suite.Clubs));
        straightFlush.add(new Card(Rank.Queen, Suite.Clubs));
        straightFlush.add(new Card(Rank.Jack, Suite.Clubs));

        assertTrue(firstMatchIs(FiveCardHands.STRAIGHT_FLUSH, straightFlush));
    }

    @Test
    public void when_GivenAFourOfAKind_FourOfAKind_Matches_Returns_True() {
        List<Card> fourOfAKind = new ArrayList<>();
        fourOfAKind.add(new Card(Rank.Nine, Suite.Clubs));
        fourOfAKind.add(new Card(Rank.Ten, Suite.Clubs));
        fourOfAKind.add(new Card(Rank.Nine, Suite.Diamonds));
        fourOfAKind.add(new Card(Rank.Nine, Suite.Hearts));
        fourOfAKind.add(new Card(Rank.Nine, Suite.Spades));

        assertTrue(firstMatchIs(FiveCardHands.FOUR_OF_A_KIND, fourOfAKind));
    }

    @Test
    public void when_GivenAFullHouse_FullHouse_Matches_Returns_True() {
        List<Card> fullHouse = new ArrayList<>();
        fullHouse.add(new Card(Rank.Nine, Suite.Clubs));
        fullHouse.add(new Card(Rank.Nine, Suite.Hearts));
        fullHouse.add(new Card(Rank.Nine, Suite.Diamonds));
        fullHouse.add(new Card(Rank.Ten, Suite.Hearts));
        fullHouse.add(new Card(Rank.Ten, Suite.Spades));

        assertTrue(firstMatchIs(FiveCardHands.FULL_HOUSE, fullHouse));
    }

    @Test
    public void when_GivenAFlush_Flush_Matches_Returns_True() {
        List<Card> flush = new ArrayList<>();
        flush.add(new Card(Rank.Nine, Suite.Clubs));
        flush.add(new Card(Rank.Jack, Suite.Clubs));
        flush.add(new Card(Rank.Two, Suite.Clubs));
        flush.add(new Card(Rank.Three, Suite.Clubs));
        flush.add(new Card(Rank.Ten, Suite.Clubs));

        assertTrue(firstMatchIs(FiveCardHands.FLUSH, flush));
    }

    @Test
    public void when_GivenAStraight_Straight_Matches_Returns_True() {
        List<Card> straight = new ArrayList<>();
        straight.add(new Card(Rank.Nine, Suite.Clubs));
        straight.add(new Card(Rank.Ten, Suite.Hearts));
        straight.add(new Card(Rank.King, Suite.Diamonds));
        straight.add(new Card(Rank.Queen, Suite.Hearts));
        straight.add(new Card(Rank.Jack, Suite.Spades));

        assertTrue(firstMatchIs(FiveCardHands.STRAIGHT, straight));
    }

    @Test
    public void when_GivenThreeOfAKind_ThreeOfAKind_Matches_Returns_True() {
        List<Card> threeOfAKind = new ArrayList<>();
        threeOfAKind.add(new Card(Rank.Nine, Suite.Clubs));
        threeOfAKind.add(new Card(Rank.Nine, Suite.Hearts));
        threeOfAKind.add(new Card(Rank.Nine, Suite.Diamonds));
        threeOfAKind.add(new Card(Rank.Queen, Suite.Hearts));
        threeOfAKind.add(new Card(Rank.Jack, Suite.Spades));

        assertTrue(firstMatchIs(FiveCardHands.THREE_OF_A_KIND, threeOfAKind));
    }

    @Test
    public void when_GivenTwoPair_TwoPair_Matches_Returns_True() {
        List<Card> twoPair = new ArrayList<>();
        twoPair.add(new Card(Rank.Nine, Suite.Clubs));
        twoPair.add(new Card(Rank.Nine, Suite.Hearts));
        twoPair.add(new Card(Rank.Queen, Suite.Diamonds));
        twoPair.add(new Card(Rank.Queen, Suite.Hearts));
        twoPair.add(new Card(Rank.Jack, Suite.Spades));

        assertTrue(firstMatchIs(FiveCardHands.TWO_PAIR, twoPair));
    }

    @Test
    public void when_GivenOnePair_OnePair_Matches_Returns_True() {
        List<Card> onePair = new ArrayList<>();
        onePair.add(new Card(Rank.Nine, Suite.Clubs));
        onePair.add(new Card(Rank.Nine, Suite.Hearts));
        onePair.add(new Card(Rank.King, Suite.Diamonds));
        onePair.add(new Card(Rank.Queen, Suite.Hearts));
        onePair.add(new Card(Rank.Jack, Suite.Spades));

        assertTrue(firstMatchIs(FiveCardHands.ONE_PAIR, onePair));
    }

    @Test
    public void when_GivenRandomCards_All_Matches_Return_False() {
        List<Card> randomStuff = new ArrayList<>();
        randomStuff.add(new Card(Rank.Two, Suite.Clubs));
        randomStuff.add(new Card(Rank.Nine, Suite.Spades));
        randomStuff.add(new Card(Rank.King, Suite.Spades));
        randomStuff.add(new Card(Rank.Queen, Suite.Spades));
        randomStuff.add(new Card(Rank.Three, Suite.Spades));

        assertTrue(Arrays.stream(FiveCardHands.values())
                .noneMatch(fiveCardHands -> fiveCardHands.matches(randomStuff)));
    }


    private boolean firstMatchIs(FiveCardHands expectedHand, List<Card> cards) {
        FiveCardHands[] allHands = FiveCardHands.values();
        Arrays.sort(allHands, Comparator.reverseOrder());
        for (FiveCardHands hand : allHands) {
            if (!hand.equals(expectedHand)
                    && hand.matches(cards)) return false;
            if (hand.equals(expectedHand)
                    && hand.matches(cards)) return true;
        }
        return false;
    }
}