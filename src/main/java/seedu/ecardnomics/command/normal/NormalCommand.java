package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

public abstract class NormalCommand extends Command {
    protected DeckList deckList;

    public NormalCommand(DeckList deckList) {
        this.deckList = deckList;
    }

    public abstract void execute() throws Exception;
}
