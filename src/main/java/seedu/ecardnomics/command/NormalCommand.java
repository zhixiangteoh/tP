package seedu.ecardnomics.command;

import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

public abstract class NormalCommand extends Command {
    protected DeckList deckList;

    public NormalCommand(DeckList deckList) {
        this.deckList = deckList;
    }

    public abstract void execute();
}
