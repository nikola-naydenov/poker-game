package poker.game.cli;

import poker.game.core.game.FiveCardDraw;
import poker.game.core.game.PokerGame;
import poker.game.model.Card;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PokerGameCLI {

    public static void main(String[] args) {
        try(PrintStream out = new PrintStream(System.out, true, "UTF-8")) {
            PokerGame game = new FiveCardDraw();
            game.shuffleDeck();
            out.println("Shuffling... Shuffling ... Shuffling ...");
            List<Card> hand = game.dealAHand();
            out.println("Your hand: " + hand);
            out.println("Your have: " + game.evaluateHand(hand));
        } catch(UnsupportedEncodingException e) {
            System.out.println("Unsupported UTF-8 encoding, cannot print the cards correctly");
        }
    }
}
