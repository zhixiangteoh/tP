package seedu.ecardnomics.command.normal;

import org.junit.jupiter.api.Test;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

import static org.junit.jupiter.api.Assertions.*;

class CreateCommandTest {

    @Test
    void execute_createNewDeck() {
        DeckList deckList = new DeckList();
        assertEquals(0, deckList.size());
        CreateCommand cmd = new CreateCommand(deckList, new Deck("Test"));
        try {
            cmd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, deckList.size());
    }
}