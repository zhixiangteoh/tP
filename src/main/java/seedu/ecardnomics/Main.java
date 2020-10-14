package seedu.ecardnomics;

import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.deck.DoneEditCommand;
import seedu.ecardnomics.command.normal.EditCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.parser.DeckParser;
import seedu.ecardnomics.parser.NormalParser;

/**
 * Main Class for eCardnomics - Flash Card Manager Command Line Program.
 */
public class Main {

    public static final double VERSION_NUMBER = 1.0;
    public static DeckList deckList = new DeckList();
    public static NormalParser normalParser = new NormalParser(deckList);

    /**
     * Executes the command.
     *
     * @param command command from parser
     */
    private static void executeCommand(Command command) {
        command.execute();
    }

    /**
     * Runs Deck Mode to edit a deck.
     *
     * @param deck Deck to edit
     * @return Command used to exit Deck Mode (either <code>done</code> or <code>exit</code>)
     */
    public static Command runDeckMode(Deck deck) {
        DeckParser deckParser = new DeckParser(deck);

        String userInput;
        Command command;

        do {
            Ui.printDeckPrompt(deck);
            userInput = Ui.readUserInput();

            command = deckParser.parse(userInput);

            executeCommand(command);

        } while (!DoneEditCommand.isDoneEdit(command)
                && !ExitCommand.isExit(command));

        return command;
    }

    /**
     * Runs Normal Mode in a loop until <code>exit</code> in input.
     * Enters Deck Mode when <code>edit</code> is input.
     */
    public static void runNormalMode() {
        Ui.printGreeting();

        String userInput;
        Command command;

        do {
            Ui.printNormalPrompt();
            userInput = Ui.readUserInput();

            command = normalParser.parse(userInput);

            executeCommand(command);

            if (EditCommand.isEdit(command)) {
                EditCommand editCommand = (EditCommand) command;
                command = runDeckMode(editCommand.getDeck());

                if (command instanceof DoneEditCommand) {
                    Ui.printNormalWelcome();
                }
            }

        } while (!ExitCommand.isExit(command));

        Ui.printExitLine();
    }

    /**
     * Main method.
     *
     * @param args Arguments from command line when user starts the program
     */
    public static void main(String[] args) {
        // TEMP FOR TESTING
        Deck pokemon = new Deck("Pokemon");
        deckList.addDeck(pokemon);
        runNormalMode();
        // runDeckMode(pokemon);
    }
}
