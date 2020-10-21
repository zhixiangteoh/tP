package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

public class CreateCommand extends NormalCommand {
    Deck newDeck;

    public CreateCommand(DeckList deckList, Deck deck) {
        super(deckList);
        assert deck != null : "Do not add null objects to the list.";
        newDeck = deck;
    }

    @Override
    public void execute() {
        deckList.addDeck(newDeck);
        Ui.printNewDeck(newDeck);
    }
}
