package seedu.ecardnomics.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.normal.DecksCommand;
import seedu.ecardnomics.command.normal.HelpCommand;
import seedu.ecardnomics.command.normal.EditCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.exceptions.DeckRangeException;
import seedu.ecardnomics.exceptions.IndexFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class NormalParserTest {
    NormalParser normalParser;

    @Test
    void getIndex_validIndex_success() throws IndexFormatException, DeckRangeException {
        assertEquals(0, normalParser.getIndex("1"));
        assertEquals(1, normalParser.getIndex("2"));
    }

    // @Test
    // void getIndex_validIndexSpacePadded_success() throws IndexFormatException, DeckRangeException {
    //     DeckParser deckParser = initialiseDeckParser();
    //     assertEquals(1, deckParser.getIndex(" 1"));
    //     assertEquals(1, deckParser.getIndex("\t1"));
    //     assertEquals(1, deckParser.getIndex("2\t"));
    //     assertEquals(1, deckParser.getIndex("     2 "));
    // }

    @Test
    void getIndex_outOfRangeIndex_exceptionThrown() {
        try {
            assertEquals(1, normalParser.getIndex("3"));
            assertEquals(1, normalParser.getIndex("-1"));
            assertEquals(1, normalParser.getIndex("0"));
            fail();
        } catch (Exception e) {
            assertEquals((new DeckRangeException()).getMessage(), e.getMessage());
        }
    }

    @Test
    void getIndex_noIndex_exceptionThrown() {
        try {
            assertEquals(1, normalParser.getIndex(""));
            assertEquals(1, normalParser.getIndex("   "));
            assertEquals(1, normalParser.getIndex("something"));
            assertEquals(1, normalParser.getIndex(" something"));
            fail();
        } catch (Exception e) {
            assertEquals((new IndexFormatException()).getMessage(), e.getMessage());
        }
    }

    @Test
    void parseCommand_ExitCommand_success() throws Exception {
        assertTrue(normalParser.parseCommand("exit", "") instanceof ExitCommand);
    }

    @Test
    void parseCommand_EditCommand_success() throws Exception {
        assertTrue(normalParser.parseCommand("done", "") instanceof EditCommand);
    }

    // @Test
    // void parseCommand_CreateCommand_success() throws Exception {
    //     assertTrue(normalParser.parseCommand("create", "") instanceof CreateCommand);
    // }

    @Test
    void parseCommand_DecksCommand_success() throws Exception {
        assertTrue(normalParser.parseCommand("decks", "") instanceof DecksCommand);
    }

    // @Test
    // void parseCommand_DeleteDeckCommand_success() throws Exception {
    //     assertTrue(normalParser.parseCommand("delete", "1") instanceof DeleteDeckCommand);
    // }

    // @Test
    // void parseCommand_DeleteDeckCommandNoIndex_exceptionThrown() {
    //     try {
    //         normalParser.parseCommand("delete", "");
    //     } catch (Exception e) {
    //         assertTrue(e instanceof IndexFormatException);
    //     }
    // }

    // @Test
    // void parseCommand_DeleteDeckCommandOutOfRangeIndex_exceptionThrown() {
    //     try {
    //         normalParser.parseCommand("delete", "3");
    //     } catch (Exception e) {
    //         assertTrue(e instanceof FlashCardRangeException);
    //     }
    // }

    @Test
    void parseCommand_HelpCommand_success() throws Exception {
        assertTrue(normalParser.parseCommand("help", "") instanceof HelpCommand);
    }

    @Test
    void parse_invalidCommand_returnsVoidCommand() {
        assertTrue(normalParser.parse("something random") instanceof VoidCommand);
        assertTrue(normalParser.parse("") instanceof VoidCommand);
        assertTrue(normalParser.parse("   ") instanceof VoidCommand);
        assertTrue(normalParser.parse("\t") instanceof VoidCommand);
        assertTrue(normalParser.parse("blah") instanceof VoidCommand);
    }

    @BeforeEach
    void initialiseDeckParser() {
        DeckList deckList = initialiseDeckList(2);
        normalParser = new NormalParser(deckList);
    }

    DeckList initialiseDeckList(int size) {
        DeckList deckList = new DeckList();
        for (int i = 1; i <= size; i++) {
            Deck deck = new Deck(String.format("deck %d", i));
            deckList.addDeck(deck);
        }
        return deckList;
    }
}