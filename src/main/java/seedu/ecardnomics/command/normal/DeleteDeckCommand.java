package seedu.ecardnomics.command.normal;


import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class DeleteDeckCommand extends NormalCommand {
    private int index;
    private boolean isVerified;

    public DeleteDeckCommand(DeckList decks, int index, boolean isVerified) {
        super(decks);
        this.index = index;
        this.isVerified = isVerified;
    }

    @Override
    public void execute() {
        if (!isVerified) {
            return;
        }
        String nameDeletedDeck = deckList.getDeck(index).getName();
        deckList.removeDeck(index);
        Ui.printDeletedDeck(nameDeletedDeck);
    }
}
