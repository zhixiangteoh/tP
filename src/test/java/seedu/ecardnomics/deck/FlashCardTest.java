package seedu.ecardnomics.deck;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlashCardTest {
    static FlashCard flashCard;

    @Test
    void testToString_default_goodFormat() {
        String flashCardString = "Question: Who's that Pokemon?\nAnswer: It's Pikachu!";
        assertEquals(flashCardString, flashCard.toString());
    }

    @Test
    void testToString_withType_goodFormat() {
        String flashCardString = "Question: Who's that Pokemon?";
        String flashCardStringWithAns = "Question: Who's that Pokemon?\nAnswer: It's Pikachu!";
        assertEquals(flashCardString, flashCard.toString("question"));
        assertEquals(flashCardStringWithAns, flashCard.toString("answer"));
    }

    @BeforeAll
    public static void createFlashCard() {
        flashCard = new FlashCard("Who's that Pokemon?", "It's Pikachu!");
    }
}