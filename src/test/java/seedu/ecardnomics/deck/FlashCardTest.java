package seedu.ecardnomics.deck;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlashCardTest {
    static FlashCard flashCard;
    static FlashCard longFlashCard;
    static FlashCard longWordFlashCard;

    @Test
    void testToString_default_goodFormat() {
        String flashCardString = "Question: Who's that Pokemon?" + System.lineSeparator()
                + "Answer:   It's Pikachu!";
        assertEquals(flashCardString, flashCard.toString());
    }

    @Test
    void testToString_default_wrappedLine() {
        String flashCardString = "Question: "
                + "Ok, long question let's goooooooo! Ahhhhhhhhhhhhh. " + System.lineSeparator()
                + "          " + "Make this question veryyyyyy longggg!" + System.lineSeparator()
                + "Answer:   " + "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! Get an "
                + System.lineSeparator()
                + "          " + "even longer answer. How many lines will this "
                + System.lineSeparator()
                + "          " + "answer span? I do not know. Maybe we can get it to "
                + System.lineSeparator()
                + "          " + "three lines? Perhaps. Anyway span reminds me of "
                + System.lineSeparator()
                + "          " + "linear algebra.";
        assertEquals(flashCardString, longFlashCard.toString());
    }

    @Test
    void testToString_default_wrapLongWord() {
        String flashCardString = "Question: Do you have " + System.lineSeparator()
                + "          " + "Pneumonoultramicroscopicsilicovolcanoconiosis?"
                + System.lineSeparator() + "Answer:   supercalifragilisticexpialidocious";
        assertEquals(flashCardString, longWordFlashCard.toString());
    }

    @Test
    void testToString_withType_goodFormat() {
        String flashCardQn = "Question: Who's that Pokemon?";
        String flashCardAns = "Answer:   It's Pikachu!";
        assertEquals(flashCardQn, flashCard.toString(true, 0));
        assertEquals(flashCardAns, flashCard.toString(false, 0));
    }

    @Test
    void testToString_withType_wrappedLine() {
        String flashCardQn = "Question: "
                + "Ok, long question let's goooooooo! Ahhhhhhhhhhhhh. " + System.lineSeparator()
                + "          " + "Make this question veryyyyyy longggg!";
        String flashCardAns = "Answer:   "
                + "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! Get an " + System.lineSeparator()
                + "          " + "even longer answer. How many lines will this "
                + System.lineSeparator()
                + "          " + "answer span? I do not know. Maybe we can get it to "
                + System.lineSeparator()
                + "          " + "three lines? Perhaps. Anyway span reminds me of "
                + System.lineSeparator()
                + "          " + "linear algebra.";
        assertEquals(flashCardQn, longFlashCard.toString(true, 0));
        assertEquals(flashCardAns, longFlashCard.toString(false, 0));
    }

    @Test
    void testToString_withType_wrapLongWord() {
        String largeSerialNumber = Integer.MAX_VALUE + ". ";
        String flashCardQn = largeSerialNumber + "Question: Do you have Pneumonoultramicroscopicsi"
                + System.lineSeparator() + "                      " + "licovolcanoconiosis?";
        String flashCardAns = " ".repeat(largeSerialNumber.length())
                + "Answer:   supercalifragilisticexpialidocious";
        assertEquals(flashCardQn, largeSerialNumber
                + longWordFlashCard.toString(true, largeSerialNumber.length()));
        assertEquals(flashCardAns, longWordFlashCard.toString(false, largeSerialNumber.length()));
    }

    @BeforeAll
    public static void createFlashCard() {
        flashCard = new FlashCard("Who's that Pokemon?", "It's Pikachu!");

        String longQuestion = "Ok, long question let's goooooooo! Ahhhhhhhhhhhhh."
                + " Make this question veryyyyyy longggg!";
        String longAnswer = "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! "
                + "Get an even longer answer. How many lines will this answer span? "
                + "I do not know. Maybe we can get it to three lines? Perhaps. "
                + "Anyway span reminds me of linear algebra.";
        longFlashCard = new FlashCard(longQuestion, longAnswer);

        String longWordQn = "Do you have Pneumonoultramicroscopicsilicovolcanoconiosis?";
        String longWordAns = "supercalifragilisticexpialidocious";
        longWordFlashCard = new FlashCard(longWordQn, longWordAns);
    }
}