package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.VersionCommand;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.game.HelpCommand;
import seedu.ecardnomics.command.game.DoneGameCommand;
import seedu.ecardnomics.command.game.GameResponseCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.exceptions.FlashCardRangeException;
import seedu.ecardnomics.exceptions.IndexFormatException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameParser extends Parser {
    public Deck deck;
    private static Logger logger = Logger.getLogger("DeckParserLogger");

    /**
     * Constructor.
     */
    public GameParser(Deck deck) {
        this.deck = deck;
    }

    @Override
    protected int getIndex(String arguments) throws IndexFormatException, FlashCardRangeException {

        arguments = arguments.trim();

        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            logger.log(Level.WARNING, "User did not enter valid integer");
            throw new IndexFormatException();
        }

        assert arguments.length() > 0 : "arguments empty!";

        int index = Integer.parseInt(arguments) - INDEX_OFFSET;

        if (index >= deck.size() || index < LOWEST_POSSIBLE_INDEX) {
            logger.log(Level.WARNING, "Flash card index larger than total number of cards");
            throw new FlashCardRangeException();
        }
        return index;
    }

    public String getInclExclYorNResponse() {
        String response = "";

        Ui.printDashLines();
        do {
            Ui.printIncludeExcludeLine();
            response = Ui.readUserInput();
            Ui.printDashLines();
            switch (response.trim()) {
            case Ui.Y:
                response = Ui.Y;
                break;
            case Ui.N:
                response = Ui.N;
                break;
            default:
                logger.log(Level.INFO, "User entered response other than 'Y' or 'N'");
                Ui.printInvalidYorNResponse();
                logger.log(Level.INFO, "Re-prompting...");
            }
        } while (!response.trim().equals(Ui.Y) && !response.trim().equals(Ui.N));
        assert response.length() == 1 : "response is not 'Y' or 'N'!";
        return response;
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments) {

        switch (commandWord) {
        // Version
        case Ui.VERSION_CMD:
            return new VersionCommand();
        // Exit
        case Ui.EXIT:
            logger.log(Level.INFO, "returning ExitCommand object");
            return new ExitCommand();
        // Done with Game Mode
        case Ui.DONE:
            logger.log(Level.INFO, "returning DoneGameCommand object");
            return new DoneGameCommand(deck);
        // Help
        case Ui.HELP:
            logger.log(Level.INFO, "returning HelpCommand object");
            return new HelpCommand();
        default:
            return new VoidCommand();
        }
    }

    @Override
    public Command parse(String userInput) {
        Command command = parseCommand(userInput.trim(), "");
        if (command instanceof VoidCommand) {
            return new GameResponseCommand(userInput.trim());
        }

        return command;
    }
}
