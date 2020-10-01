package seedu.ecardnomics.command;

import seedu.ecardnomics.deck.Deck;

public class NormalCommand extends Command {
    protected Deck currentDeck;

    public NormalCommand(Deck currentDeck) {
        this.currentDeck = currentDeck;
    }
}
