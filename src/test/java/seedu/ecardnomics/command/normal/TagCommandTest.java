package seedu.ecardnomics.command.normal;

import org.junit.jupiter.api.Test;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagCommandTest {

    @Test
    void execute_addNewTagsToExistingDeck() {
        DeckList deckList = new DeckList();
        Deck newDeck = new Deck("Pokemon");
        deckList.addDeck(newDeck);
        String[] newTags = {"anime", "unreal"};
        TagCommand cmd = new TagCommand(deckList, 0, newTags);
        cmd.execute();
        assertEquals(2, deckList.getDeck(0).getTag().size());
    }
}
