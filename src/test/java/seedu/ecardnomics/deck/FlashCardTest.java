package seedu.ecardnomics.deck;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlashCardTest {
    static FlashCard flashCard;

    @Test
    void testToString_default_goodFormat() {
        String flashCardString = "Question: Who's that Pokemon?\n   Answer:   It's Pikachu!";
        assertEquals(flashCardString, flashCard.toString());
    }

    @Test
    void testToString_default_wrappedLine() {
        String question = "Ok, long question let's goooooooo! Ahhhhhhhhhhhhh."
                + " Make this question veryyyyyy longggg!";
        String answer = "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! "
                + "Get an even longer answer. How many lines will this answer span? "
                + "I do not know. Maybe we can get it to three lines? Perhaps. "
                + "Anyway span reminds me of linear algebra.";
        FlashCard longFlashCard = new FlashCard(question, answer);
        String flashCardString = "Question: "
                + "Ok, long question let's goooooooo! " + System.lineSeparator()
                + "             " + "Ahhhhhhhhhhhhh. Make this question veryyyyyy "
                + System.lineSeparator()
                + "             " + "longggg!" + "\n" + "   Answer:   "
                + "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! Get an " + System.lineSeparator()
                + "             " + "even longer answer. How many lines will this "
                + System.lineSeparator()
                + "             " + "answer span? I do not know. Maybe we can get it "
                + System.lineSeparator()
                + "             " + "to three lines? Perhaps. Anyway span reminds me "
                + System.lineSeparator()
                + "             " + "of linear algebra.";
        assertEquals(flashCardString, longFlashCard.toString());
    }

    @Test
    void testToString_withType_goodFormat() {
        String flashCardString = "Question: Who's that Pokemon?";
        String flashCardStringWithAns = "Question: Who's that Pokemon?\n   Answer:   It's Pikachu!";
        assertEquals(flashCardString, flashCard.toString("question"));
        assertEquals(flashCardStringWithAns, flashCard.toString("answer"));
    }

    @Test
    void testToString_withType_wrappedLine() {
        String question = "Ok, long question let's goooooooo! Ahhhhhhhhhhhhh."
                + " Make this question veryyyyyy longggg!";
        String answer = "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! "
                + "Get an even longer answer. How many lines will this answer span? "
                + "I do not know. Maybe we can get it to three lines? Perhaps. "
                + "Anyway span reminds me of linear algebra.";
        FlashCard longFlashCard = new FlashCard(question, answer);
        String flashCardString = "Question: "
                + "Ok, long question let's goooooooo! " + System.lineSeparator()
                + "             " + "Ahhhhhhhhhhhhh. Make this question veryyyyyy "
                + System.lineSeparator()
                + "             " + "longggg!";
        String flashCardStringWithAns = flashCardString + "\n" + "   Answer:   "
                + "Ahhhhhhhhhhhhhhhhhhhhhhhh!!!!!!!!!!!!!! Get an " + System.lineSeparator()
                + "             " + "even longer answer. How many lines will this "
                + System.lineSeparator()
                + "             " + "answer span? I do not know. Maybe we can get it "
                + System.lineSeparator()
                + "             " + "to three lines? Perhaps. Anyway span reminds me "
                + System.lineSeparator()
                + "             " + "of linear algebra.";
        assertEquals(flashCardString, longFlashCard.toString("question"));
        assertEquals(flashCardStringWithAns, longFlashCard.toString("answer"));
    }

    @BeforeAll
    public static void createFlashCard() {
        flashCard = new FlashCard("Who's that Pokemon?", "It's Pikachu!");
    }
}