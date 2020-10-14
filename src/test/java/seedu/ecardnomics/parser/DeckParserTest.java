package seedu.ecardnomics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.deck.AddCommand;
import seedu.ecardnomics.command.deck.DeleteCommand;
import seedu.ecardnomics.command.deck.DoneEditCommand;
import seedu.ecardnomics.command.deck.ListCommand;
import seedu.ecardnomics.command.deck.HelpCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.FlashCard;
import seedu.ecardnomics.exceptions.FlashCardRangeException;
import seedu.ecardnomics.exceptions.IndexFormatException;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class DeckParserTest {
    DeckParser deckParser;

    @Test
    void getIndex_validIndex_success() throws IndexFormatException, FlashCardRangeException {
        assertEquals(0, deckParser.getIndex("1"));
        assertEquals(1, deckParser.getIndex("2"));
    }

    @Test
    void getIndex_validIndexSpacePadded_success() throws IndexFormatException, FlashCardRangeException {
        assertEquals(0, deckParser.getIndex(" 1"));
        assertEquals(0, deckParser.getIndex("\t1"));
        assertEquals(1, deckParser.getIndex("2\t"));
        assertEquals(1, deckParser.getIndex("     2 "));
    }

    @Test
    void getIndex_outOfRangeIndex_exceptionThrown() {
        try {
            assertEquals(1, deckParser.getIndex("3"));
            assertEquals(1, deckParser.getIndex("0"));
            fail();
        } catch (Exception e) {
            assertEquals((new FlashCardRangeException()).getMessage(), e.getMessage());
        }
    }

    @Test
    void getIndex_noIndex_exceptionThrown() {
        try {
            assertEquals(1, deckParser.getIndex(""));
            assertEquals(1, deckParser.getIndex("   "));
            assertEquals(1, deckParser.getIndex("something"));
            assertEquals(1, deckParser.getIndex(" something"));
            fail();
        } catch (Exception e) {
            assertEquals((new IndexFormatException()).getMessage(), e.getMessage());
        }
    }

    @Test
    void parseCommand_ExitCommand_success() throws Exception {
        assertTrue(deckParser.parseCommand("exit", "") instanceof ExitCommand);
    }

    @Test
    void parseCommand_DoneEditCommand_success() throws Exception {
        assertTrue(deckParser.parseCommand("done", "") instanceof DoneEditCommand);
    }

    // @Test
    //void parseCommand_AddCommand_success() throws Exception {
    //assertTrue(deckParser.parseCommand("add", "") instanceof AddCommand);
    //}

    @Test
    void parseCommand_ListCommand_success() throws Exception {
        assertTrue(deckParser.parseCommand("list", "") instanceof ListCommand);
    }

    //@Test
    //void parseCommand_DeleteCommand_success() throws Exception {
    //assertTrue(deckParser.parseCommand("delete", "1") instanceof DeleteCommand);
    //}

    @Test
    void parseCommand_DeleteCommandNoIndex_exceptionThrown() {
        try {
            deckParser.parseCommand("delete", "");
        } catch (Exception e) {
            assertTrue(e instanceof IndexFormatException);
        }
    }

    @Test
    void parseCommand_DeleteCommandOutOfRangeIndex_exceptionThrown() {
        try {
            deckParser.parseCommand("delete", "3");
        } catch (Exception e) {
            assertTrue(e instanceof FlashCardRangeException);
        }
    }

    @Test
    void parseCommand_HelpCommand_success() throws Exception {
        assertTrue(deckParser.parseCommand("help", "") instanceof HelpCommand);
    }

    @Test
    void parse_invalidCommand_returnsVoidCommand() {
        assertTrue(deckParser.parse("something random") instanceof VoidCommand);
        assertTrue(deckParser.parse("") instanceof VoidCommand);
        assertTrue(deckParser.parse("   ") instanceof VoidCommand);
        assertTrue(deckParser.parse("\t") instanceof VoidCommand);
        assertTrue(deckParser.parse("blah") instanceof VoidCommand);
    }

    //@BeforeAll
    //public static void addUserInput() {
    //String userInputs = "q1" + System.getProperty("line.separator") + "a1" + System.getProperty("line.separator")
    //+ "y" + System.getProperty("line.separator") + "y";
    //ByteArrayInputStream input = new ByteArrayInputStream(userInputs.getBytes());
    //System.setIn(input);
    //}

    @BeforeEach
    void initialiseDeckParser() {
        Deck deck = initialiseDeck(2);
        deckParser = new DeckParser(deck);
    }

    Deck initialiseDeck(int size) {
        Deck deck = new Deck("Pokemon");
        for (int i = 1; i <= size; i++) {
            FlashCard flashCard = new FlashCard(String.format("q %d", i), String.format("a %d", i));
            deck.add(flashCard);
        }
        return deck;
    }


}