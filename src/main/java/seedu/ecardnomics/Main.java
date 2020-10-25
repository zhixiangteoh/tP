package seedu.ecardnomics;

import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.deck.DoneEditCommand;
import seedu.ecardnomics.command.game.DoneGameCommand;
import seedu.ecardnomics.command.game.GameStartCommand;
import seedu.ecardnomics.command.normal.EditCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.normal.StartCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.deck.FlashCard;
import seedu.ecardnomics.game.Game;
import seedu.ecardnomics.parser.DeckParser;
import seedu.ecardnomics.parser.GameParser;
import seedu.ecardnomics.parser.NormalParser;
import seedu.ecardnomics.storage.Storage;

/**
 * Main Class for eCardnomics - Flash Card Manager Command Line Program.
 */
public class Main {

    public static final double VERSION_NUMBER = 1.0;
    public static DeckList deckList = new DeckList();
    public static NormalParser normalParser = new NormalParser(deckList);
    public static Storage storage = new Storage();

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
     * Runs Game Mode for specified deck.
     *
     * @param deck to run Game Mode on
     * @return Command used to exit Game Mode (either <code>done</code> or <code>exit</code>)
     */
    public static Command runGameMode(Deck deck) {
        GameStartCommand gameStartCommand = new GameStartCommand(deck);
        executeCommand(gameStartCommand);

        Game game = gameStartCommand.getGameInstance();
        return game.run();
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

            if (StartCommand.isStart(command)) {
                StartCommand startCommand = (StartCommand) command;
                command = runGameMode(startCommand.getDeck());

                if (command instanceof DoneGameCommand) {
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
        // Deck pokemon = new Deck("Pokemon");
        // deckList.addDeck(pokemon);
        // pokemon.add(new FlashCard("Who's that Pokemon?", "It's Pikachu!"));
        // pokemon.add(new FlashCard("Who's that Digimon?", "It's Agumon!"));
        // pokemon.add(new FlashCard("Who's that Ben 10 alien?", "It's Grey Matter!"));
        // pokemon.add(new FlashCard("Who's that Dog?", "It's Scooby-Doo!"));
        // pokemon.add(new FlashCard("A Question 5", "It's Question 5"));
        // pokemon.add(new FlashCard("B Question 6", "It's Question 6"));
        // pokemon.add(new FlashCard("C Question 7", "It's Question 7"));
        // pokemon.add(new FlashCard("D Question 8", "It's Question 8"));

        deckList = storage.load(deckList);
        runNormalMode();

        try {
            storage.write(Main.deckList);
        } catch (Exception e) {
            System.out.println("Unable to write file...");
        }
    }
}
