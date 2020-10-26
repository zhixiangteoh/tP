package seedu.ecardnomics.command.normal;


import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class DeleteDeckCommand extends NormalCommand {
    private int index;

    public DeleteDeckCommand(DeckList decks, int index) {
        super(decks);
        assert (index >= 0 && index < decks.size()) : "Index must be within range.";
        this.index = index;
    }

    @Override
    public void execute() {
        boolean isDeckDeleted = Ui.getDeletedDeckConfirmation(deckList.getDeck(index).getName());
        if (isDeckDeleted) {
            deckList.removeDeck(index);
        }
    }
}
