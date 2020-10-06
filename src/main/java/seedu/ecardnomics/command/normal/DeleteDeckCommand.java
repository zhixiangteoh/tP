package seedu.ecardnomics.command.normal;


import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.NormalCommand;
import seedu.ecardnomics.deck.DeckList;

public class DeleteDeckCommand extends NormalCommand {
    public int deckID;

    public DeleteDeckCommand(DeckList decks, int deckID) {
        super(decks);
        this.deckID = deckID;
    }

    @Override
    public void execute() {
        String nameDeletedDeck = deckList.getDeck(deckID -Ui.INDEX_OFFSET).getName();
        Ui.printDeletedDeckQuestion(nameDeletedDeck);
        String answer = Ui.readUserInput();
        switch (answer) {
        case "y":
            deckList.removeDeck(deckID - Ui.INDEX_OFFSET);
            Ui.printDeletedDeck(nameDeletedDeck);
            break;
        case "n":
            //
            break;
        default:
            //
        }
    }
}
