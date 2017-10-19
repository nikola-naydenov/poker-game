package poker.game.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RankTest {
    @Test
    public void assertThat_Ace_isGreaterThan_Two() {
        assertTrue(Rank.Ace.compareTo(Rank.Two) > 0);
    }
}