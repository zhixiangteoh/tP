package seedu.ecardnomics;

import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.deck.FlashCard;

import java.util.Scanner;

public class Ui {

    public static final String GREETING_LINES =
            "Hello! Welcome to eCardnomics,\n"
                    + "your one stop Flash Cards solution";
    public static final String NORMAL_WELCOME_LINE =
            "You are back in Normal Mode";
    public static final String DECK_WELCOME_LINE =
            "You are now in Deck Mode, editing: ";
    public static final String BYE_LINE =
            "Bye. Hope to see you again soon!";
    public static final String NOT_RECOGNISED_LINE =
            "Command not recognised";
    public static final String YN_LINE = "[y/n]";
    public static final String ADD_FLASHCARD_LINE =
            "You are now adding a FlashCard to: ";
    public static final String ENTER_QUESTION_LINE =
            "Enter question:";
    public static final String ENTER_ANSWER_LINE =
            "Enter answer:";
    public static final String FLASHCARD_ADDED_LINE =
            "FlashCard successfully added!";
    public static final String LIST_FLASHCARDS_LINE =
            "You are now viewing deck: ";
    public static final String DELETE_FLASHCARD_LINE =
            "Do you want to delete ";
    public static final String FLASHCARD_DELETED_LINE =
            " has been deleted.";
    public static final String NEW_DECK_CREATED_LINE =
            "New deck created: ";
    public static final String DECKS_AVAILABLE_LINE =
            "The following decks are available: ";
    public static final String DELETED_DECK_QUESTION_LINE =
            "Do you want to delete %1$s deck? [y/n]";
    public static final String DELETED_DECK_LINE =
            "%1$s has been deleted.";
    public static final String INVALID_YN_RESPONSE_LINE =
            "Response should be 'y' or 'n'!";


    public static final String EXIT = "exit";
    public static final String EDIT = "edit";
    public static final String DONE = "done";
    public static final String ADD = "add";
    public static final String CREATE = "create";
    public static final String LIST = "list";
    public static final String DECKS = "decks";
    public static final String DELETE = "delete";
    public static final String HELP = "help";

    //Regex
    public static final String DIGITS_REGEX = "\\d+";
    public static final int INDEX_OFFSET = 1;

    public static final String Y = "y";
    public static final String N = "n";
    public static final String DASH_LINES = "------------------------------------------------------------";

    public static Scanner in = new Scanner(System.in);

    /**
     * Reads user input from command line.
     *
     * @return String containing userInput
     */
    public static String readUserInput() {
        return in.nextLine();
    }

    /** Displays dash line. */
    public static void printDashLines() {
        System.out.println(DASH_LINES);
    }

    /**
     * Displays the message given.
     *
     * @param message message to be displayed to user
     */
    public static void printMessage(String message) {
        printDashLines();
        System.out.println(message);
        printDashLines();
    }

    /**
     * Displays the prompt for user input in Normal Mode.
     */
    public static void printNormalPrompt() {
        System.out.println("[Normal]");
        System.out.print("  > ");
    }

    /**
     * Displays the prompt for user input in Deck Mode.
     */
    public static void printDeckPrompt(Deck deck) {
        System.out.println("[Deck - " + deck.getName() + "]");
        System.out.print("  > ");
    }

    /**
     * Displays the prompt for user input without specifying current mode.
     */
    public static void printPrompt(Deck deck) {
        System.out.println("[Deck - " + deck.getName() + "]");
        System.out.print("  > ");
    }

    /**
     * Displays the welcome message from Deck Mode to Normal Mode.
     */
    public static void printNormalWelcome() {
        printMessage(NORMAL_WELCOME_LINE);
    }

    /**
     * Displays the welcome message from Normal Mode to Deck Mode.
     */
    public static void printDeckWelcome(int index, Deck deck) {
        printMessage(DECK_WELCOME_LINE + "[" + index + "] " + deck.getName());
    }

    /**
     * Displays the greeting message.
     */
    public static void printGreeting() {
        printMessage(GREETING_LINES);
    }

    /**
     * Displays the exit message.
     */
    public static void printExitLine() {
        printMessage(BYE_LINE);
    }

    /**
     * Displays the not recognised message.
     */
    public static void printNotRecognisedLine() {
        printMessage(NOT_RECOGNISED_LINE);
    }

    /**
     * Displays the add FlashCard line.
     *
     * @param deck current deck
     */
    public static void printAddFlashCardLine(Deck deck) {
        printMessage(ADD_FLASHCARD_LINE + deck.getName());
    }

    /**
     * Displays the enter question line.
     */
    public static void printEnterQuestionLine() {
        System.out.println(ENTER_QUESTION_LINE);
        System.out.print("  > ");
    }

    /**
     * Displays the enter answer line.
     */
    public static void printEnterAnswerLine() {
        System.out.println(ENTER_ANSWER_LINE);
        System.out.print("  > ");
    }

    /**
     * Displays the FlashCard added line.
     */
    public static void printFlashCardAddedLine() {
        System.out.println(FLASHCARD_ADDED_LINE);
    }

    /**
     * Displays an index list of FlashCards in the deck.
     *
     * @param deck deck to display
     * @param type optional <code>/ans</code> to display answers
     */
    public static void printDeck(Deck deck, String type) {
        printMessage(LIST_FLASHCARDS_LINE + deck.getName());
        System.out.print(deck.toString(type));
        printDashLines();
    }

    /**
     * Displays the delete FlashCard line.
     *
     * @param flashCard FlashCard to delete
     */
    public static void printDeleteFlashCardLine(FlashCard flashCard) {
        System.out.print(DELETE_FLASHCARD_LINE + flashCard.getQuestion() + "? " + YN_LINE + " ");
    }

    /**
     * Displays the FlashCard deleted line.
     *
     * @param flashCard deleted FlashCard
     */
    public static void printFlashCardDeletedLine(FlashCard flashCard) {
        System.out.println(flashCard.getQuestion() + FLASHCARD_DELETED_LINE);
    }

    /**
     * Displays the help page of commands.
     *
     * <p>Displays a different help page for Normal Mode and Deck Mode.</p>
     *
     * @param helpDisplay help text to display
     */
    public static void printHelp(String helpDisplay) {
        printMessage(helpDisplay);
    }

    /**
     * Prints new deck added in the Normal Mode.
     *
     * @param deck in new Deck added
     */
    public static void printNewDeck(Deck deck) {
        System.out.println(NEW_DECK_CREATED_LINE + deck.getName());
    }

    /**
     * Prints all decks available in the Normal Mode.
     *
     * @param decks all decks in the list
     */
    public static void printDeckList(DeckList decks) {
        System.out.println(DECKS_AVAILABLE_LINE);
        System.out.println(decks.toString());

    }

    /**
     * Confirms the deck the user wants to delete.
     *
     * @param deletedDeckName name of the deleted deck
     */
    public static void printDeletedDeckQuestion(String deletedDeckName) {
        System.out.println(String.format(DELETED_DECK_QUESTION_LINE, deletedDeckName));
    }

    /**
     * Prints the name of the deleted deck.
     *
     * @param deletedDeckName name of the deleted deck
     */
    public static void printDeletedDeck(String deletedDeckName) {
        System.out.println(String.format(DELETED_DECK_LINE, deletedDeckName));
    }

    public static void printInvalidYNResponse() {
        System.out.println(INVALID_YN_RESPONSE_LINE);
    }
}
