package seedu.ecardnomics.command.normal;

import org.junit.jupiter.api.Test;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteDeckCommandTest {
    private static final String USER_INPUT = "y" + System.lineSeparator() + "n";
    private DeckList deckList;
    ByteArrayInputStream testIn;
    InputStream stdin;

    DeleteDeckCommandTest() {
        deckList = new DeckList();
        testIn = new ByteArrayInputStream(USER_INPUT.getBytes());
        stdin = System.in;
    }

    @Test
    void execute_deleteExistingDeck() {
        deckList.addDeck(new Deck("Test deck"));
        assertEquals(1, deckList.size());
        DeleteDeckCommand cmd = new DeleteDeckCommand(deckList, 1);
        switchInputStream();
        // Execute the command
        cmd.execute();
        assertEquals(0, deckList.size());
        restoreStdin();
    }

    @Test
    void execute_doNotDeleteDeck() {
        deckList.addDeck(new Deck("Test deck"));
        assertEquals(1, deckList.size());
        DeleteDeckCommand cmd = new DeleteDeckCommand(deckList, 1);
        switchInputStream();
        // Execute the command
        cmd.execute();
        assertEquals(1, deckList.size());
        restoreStdin();
    }

    void switchInputStream() {
        System.setIn(testIn);
    }

    void restoreStdin() {
        System.setIn(stdin);
    }
}