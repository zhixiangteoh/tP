package seedu.ecardnomics.command.normal;


import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class DeleteDeckCommand extends NormalCommand {
    public int index;

    public DeleteDeckCommand(DeckList decks, int index) {
        super(decks);
        this.index = index;
    }

    @Override
    public void execute() {
        String nameDeletedDeck = deckList.getDeck(index).getName();
        Ui.printDeletedDeckQuestion(nameDeletedDeck);
        String answer = Ui.readUserInput();

        deckList.removeDeck(index);
        Ui.printDeletedDeck(nameDeletedDeck);
    }
}
