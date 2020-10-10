package seedu.ecardnomics.command.deck;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.DeckCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.FlashCard;

import static seedu.ecardnomics.parser.DeckParser.getDeleteYNResponse;

public class DeleteCommand extends DeckCommand {
    private int flashCardID;
    private String response;

    public DeleteCommand(Deck deck, int flashCardID) {
        super(deck);
        this.flashCardID = flashCardID;
    }

    @Override
    public void execute() {
        int deleteIndex = flashCardID - Ui.INDEX_OFFSET;
        FlashCard flashCard = currentDeck.get(deleteIndex);
        response = getDeleteYNResponse(flashCard);
        switch (response) {
        case "y":
            Ui.printFlashCardDeletedLine(flashCard);
            Ui.printDashLines();
            currentDeck.delete(deleteIndex);
            break;
        case "n":
            //
            break;
        default:
            //
        }
    }
}
