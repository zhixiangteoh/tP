package seedu.ecardnomics.command.normalmode;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.NormalCommand;
import seedu.ecardnomics.deck.DeckList;

public class DecksCommand extends NormalCommand {

    public DecksCommand(DeckList deckList) {
        super(deckList);
    }

    @Override
    public void execute() {
        Ui.printDeckList(deckList);
    }
}
