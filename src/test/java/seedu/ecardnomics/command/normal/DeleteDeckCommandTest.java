package seedu.ecardnomics.command.normal;

import org.junit.jupiter.api.Test;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteDeckCommandTest {

    @Test
    void execute_confirmDeleteDeck() {
        DeckList deckList = new DeckList();
        deckList.addDeck(new Deck("Test"));
        assertEquals(1, deckList.size());
        DeleteDeckCommand cmd = new DeleteDeckCommand(deckList, 0, true);
        cmd.execute();
        assertEquals(0, deckList.size());
    }

    @Test
    void execute_notConfirmedDeleteDeck() {
        DeckList deckList = new DeckList();
        deckList.addDeck(new Deck("Test"));
        assertEquals(1, deckList.size());
        DeleteDeckCommand cmd = new DeleteDeckCommand(deckList, 0, false);
        cmd.execute();
        assertEquals(1, deckList.size());
    }
}