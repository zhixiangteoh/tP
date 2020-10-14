package seedu.ecardnomics.command.deck;

import seedu.ecardnomics.deck.Deck;

public class DeleteCommand extends DeckCommand {
    private int flashCardID;
    private boolean isFlashCardDeleted;

    public DeleteCommand(Deck deck, int flashCardID, boolean isFlashCardDeleted) {
        super(deck);
        this.flashCardID = flashCardID;
        this.isFlashCardDeleted = isFlashCardDeleted;
    }

    @Override
    public void execute() {
        if (isFlashCardDeleted) {
            currentDeck.delete(flashCardID);
        }
    }
}
