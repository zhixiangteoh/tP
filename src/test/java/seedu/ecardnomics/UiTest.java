package seedu.ecardnomics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void printMessage_singleLine_goodFormat() {
        String singleLine = "Hello! Welcome to eCardnomics!\t\t\tFlashCards Application.";
        String message = Ui.DASH_LINES + "\n" + singleLine + "\n" + Ui.DASH_LINES  + "\n";
        Ui.printMessage(singleLine);
        assertEquals(message, outContent.toString());
    }

    @Test
    void printNormalPrompt() {
    }

    @Test
    void printDeckPrompt() {
    }

    @Test
    void printPrompt() {
    }

    @Test
    void printNormalWelcome() {
    }

    @Test
    void printDeckWelcome() {
    }

    @Test
    void printGreeting() {
    }

    @Test
    void printExitLine() {
    }

    @Test
    void printNotRecognisedLine() {
    }

    @Test
    void printAddFlashCardLine() {
    }

    @Test
    void printEnterQuestionLine() {
    }

    @Test
    void printEnterAnswerLine() {
    }

    @Test
    void printFlashCardAddedLine() {
    }

    @Test
    void printDeck() {
    }

    @Test
    void printDeleteFlashCardLine() {
    }

    @Test
    void printFlashCardDeletedLine() {
    }

    @Test
    void printHelp() {
    }

    @Test
    void printNewDeck() {
    }

    @Test
    void printDeckList() {
    }

    @Test
    void printDeletedDeckQuestion() {
    }

    @Test
    void printDeletedDeck() {
    }
}
