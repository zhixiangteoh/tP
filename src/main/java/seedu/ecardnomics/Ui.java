package seedu.ecardnomics;

import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.deck.FlashCard;

import java.util.ArrayList;
import java.util.Scanner;

import static seedu.ecardnomics.Main.VERSION_NUMBER;

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
            "Do you want to delete the following flash card? ";
    public static final String FLASHCARD_DELETED_LINE =
            "The following flash card has been deleted:\n  '";
    public static final String NEW_DECK_CREATED_LINE =
            "New deck created: ";
    public static final String DECKS_AVAILABLE_LINE =
            "The following decks are available:\n";
    public static final String DELETED_DECK_QUESTION_LINE =
            "Do you want to delete %1$s deck? [y/n]";
    public static final String DELETED_DECK_LINE =
            "%1$s has been deleted.";
    public static final String INVALID_YN_RESPONSE_LINE =
            "Response should be 'y' or 'n'!";
    private static final String EMPTY_DECK_LINE =
            "Deck is currently empty!";
    private static final String ALL_TAGS_LINE =
            "The deck %1$s has been tagged as %2$s ";
    private static final String REMOVED_TAGS_QUESTION_LINE =
            "Do you want to remove the tag(s) %1$s from %2$s? [y/n]";
    private static final String REMOVED_TAGS_LINE =
            "The tag(s) %1$s have been removed from the deck %2$s.";
    private static final String NEW_QUESTION_LINE =
            "New Question: ";
    private static final String NEW_ANSWER_LINE =
            "New Answer: ";
    private static final String QUESTION_UPDATED_LINE =
            "Question updated.";
    private static final String ANSWER_UPDATED_LINE =
            "Answer updated.";
    private static final String QNA_UPDATED_LINE =
            "Question and answer updated.";
    private static final String NO_UPDATE_LINE =
            "Original question and answer retained";

    public static final String EXIT = "exit";
    public static final String EDIT = "edit";
    public static final String DONE = "done";
    public static final String ADD = "add";
    public static final String CREATE = "create";
    public static final String LIST = "list";
    public static final String DECKS = "decks";
    public static final String DELETE = "delete";
    public static final String UPDATE = "update";
    public static final String HELP = "help";
    public static final String TAG = "tag";
    public static final String UNTAG = "untag";

    public static final String VERSION_CMD = "--version";

    //Regex
    public static final String DIGITS_REGEX = "\\d+";

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
    public static void printPrompt() {
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
        printPrompt();
    }

    /**
     * Displays the enter answer line.
     */
    public static void printEnterAnswerLine() {
        System.out.println(ENTER_ANSWER_LINE);
        printPrompt();
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
        String deckMessage = "";
        if (deck.toString(type).trim().equals("")) {
            deckMessage += EMPTY_DECK_LINE;
        } else {
            deckMessage += LIST_FLASHCARDS_LINE + deck.getName() + "\n"
                    + deck.toString(type);
        }
        printMessage(deckMessage);
    }

    /**
     * Displays the delete FlashCard line.
     *
     * @param flashCard FlashCard to delete
     */
    public static void printDeleteFlashCardLine(FlashCard flashCard) {
        System.out.print(DELETE_FLASHCARD_LINE + YN_LINE + "\n  '" + flashCard.getQuestion() + "`\n");
        printPrompt();
    }

    /**
     * Displays the FlashCard deleted line.
     *
     * @param flashCard deleted FlashCard
     */
    public static void printFlashCardDeletedLine(FlashCard flashCard) {
        System.out.println(FLASHCARD_DELETED_LINE + flashCard.getQuestion() + "'");
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
        printMessage(NEW_DECK_CREATED_LINE + deck.getName()
                + ": " + deck.getTag());
    }

    /**
     * Prints all decks available in the Normal Mode.
     *
     * @param decks all decks in the list
     */
    public static void printDeckList(DeckList decks) {
        printMessage(DECKS_AVAILABLE_LINE + decks.toString());
    }

    /**
     * Confirms the deck the user wants to delete.
     *
     * @param deletedDeckName name of the deleted deck
     */
    public static void printDeletedDeckQuestion(String deletedDeckName) {
        System.out.print(String.format(DELETED_DECK_QUESTION_LINE, deletedDeckName));
    }

    /**
     * Prints the name of the deleted deck.
     *
     * @param deletedDeckName name of the deleted deck
     */
    public static void printDeckDeletedLine(String deletedDeckName) {
        System.out.println(String.format(DELETED_DECK_LINE, deletedDeckName));
    }

    /**
     * Prints the update question lines for a flashcard.
     *
     * @param flashCard for which the question should be updated.
     */
    public static void printUpdateQuestionLine(FlashCard flashCard) {
        System.out.println(flashCard.toString("question"));
        System.out.println(NEW_QUESTION_LINE);
        printPrompt();
    }

    /**
     * Prints the update answer lines for a flashcard.
     *
     * @param flashCard for which the answer should be updated.
     */
    public static void printUpdateAnswerLine(FlashCard flashCard) {
        System.out.println(flashCard.toString("answer"));
        System.out.println(NEW_ANSWER_LINE);
        printPrompt();
    }

    public static void printFlashCardUpdatedLine(boolean hasNewQ, boolean hasNewA) {
        if (hasNewQ && hasNewA) {
            System.out.println(QNA_UPDATED_LINE);
        } else if (hasNewQ) {
            // !hasNewA
            System.out.println(QUESTION_UPDATED_LINE);
        } else if (hasNewA) {
            // !hasNewQ
            System.out.println(ANSWER_UPDATED_LINE);
        } else {
            System.out.println(NO_UPDATE_LINE);
        }
    }

    /**
     * Prints a line prompting user to enter only 'y' or 'n'.
     */
    public static void printInvalidYorNResponse() {
        System.out.println(INVALID_YN_RESPONSE_LINE);
    }

    public static void printVersionNumber() {
        printMessage("Version: " + VERSION_NUMBER);
    }

    public  static void printTags(String name, String tags) {
        System.out.println(String.format(ALL_TAGS_LINE, name, tags));
    }

    public static void printRemovedTagsQuestion(String deckName, String[] tags) {
        String removedTags = formStringOfTags(tags);
        System.out.println(String.format(REMOVED_TAGS_QUESTION_LINE, removedTags, deckName));
    }

    public static void printTagsRemovedLine(String deckName, String[] tags) {
        String removedTags = formStringOfTags(tags);
        System.out.println(String.format(REMOVED_TAGS_LINE, removedTags, deckName));
    }

    public static String formStringOfTags(String[] tags) {
        String stringOfTags = "";

        for (int i = 0; i < tags.length; i++) {
            stringOfTags += tags[i];
            if (i < tags.length - 1) {
                stringOfTags += ", ";
            }
        }
        return stringOfTags;
    }

}
