package seedu.ecardnomics.command;

import seedu.ecardnomics.deck.Deck;

public abstract class DeckCommand extends Command {
    protected Deck currentDeck;

    public DeckCommand() {
        currentDeck = null;
    }

    public DeckCommand(Deck currentDeck) {
        this.currentDeck = currentDeck;
    }

    public abstract void execute();
}
