package seedu.ecardnomics;

import seedu.ecardnomics.deck.Deck;

import java.util.Scanner;

public class Ui {

    public static final String GREETING_LINES =
            "Hello! Welcome to eCardnomics, \n"
                    + "your one stop Flash Cards solution";
    public static final String NORMAL_WELCOME_LINE =
            "You are back in Normal Mode";
    public static final String DECK_WELCOME_LINE =
            "You are now in Deck Mode, editing: ";
    public static final String BYE_LINE =
            "Bye. Hope to see you again soon!";
    public static final String NOT_RECOGNISED_LINE =
            "Command not recognised";

    public static final String EXIT = "exit";
    public static final String EDIT = "edit";
    public static final String DONE = "done";

    //Regex
    public static final String DIGITS_REGEX = "\\d+";

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
        System.out.println("------------------------------------------------------------");
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
}
