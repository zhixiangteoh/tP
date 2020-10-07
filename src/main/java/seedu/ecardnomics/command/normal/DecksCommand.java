package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class DecksCommand extends NormalCommand {

    public DecksCommand(DeckList deckList) {
        super(deckList);
    }

    @Override
    public void execute() throws Exception {
        Ui.printDeckList(deckList);
    }
}
