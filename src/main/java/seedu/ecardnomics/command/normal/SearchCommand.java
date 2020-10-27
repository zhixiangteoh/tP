package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

import java.util.ArrayList;

public class SearchCommand extends NormalCommand {
    private String[] relevantTags;

    /** Constructor. */
    public SearchCommand(DeckList decks, String[] relevantTags) {
        super(decks);
        assert  (relevantTags.length != 0): "Relevant tags must be provided.";
        this.relevantTags = relevantTags;
    }

    @Override
    public void execute() {
        String decksHavingTags = "";
        ArrayList<Deck> allDecks = deckList.getAllDecks();
        for (String tag: relevantTags) {
            for (int i = 0; i < deckList.size(); i++) {
                if (allDecks.get(i).getTag().contains(tag)) {
                    decksHavingTags += "\n" + (i+1) + ". " + allDecks.get(i).getName();
                }
            }
        }
        Ui.printSearchDecksLine(decksHavingTags);
    }
}
