package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.normal.EditCommand;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.normal.CreateCommand;
import seedu.ecardnomics.command.normal.DecksCommand;
import seedu.ecardnomics.command.normal.DeleteDeckCommand;
import seedu.ecardnomics.command.normal.HelpCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.exceptions.DeckRangeException;
import seedu.ecardnomics.exceptions.EmptyInputException;
import seedu.ecardnomics.exceptions.IndexFormatException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parser for commands supplied in Normal Mode.
 */
public class NormalParser extends Parser {
    DeckList deckList;
    private static Logger logger = Logger.getLogger("NormalParserLogger");

    /** Constructor. */
    public NormalParser(DeckList deckList) {
        this.deckList = deckList;
    }

    @Override
    protected int getIndex(String arguments)
            throws IndexFormatException, DeckRangeException {

        logger.log(Level.INFO, "Logging method getIndex() in NormalParser.");
        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            logger.log(Level.WARNING, "User did not enter a valid integer index.");
            throw new IndexFormatException();
        }

        int index = Integer.parseInt(arguments) - Ui.INDEX_OFFSET;

        if ((index >= deckList.size()) || (index < 0)) {
            logger.log(Level.WARNING, "User did not enter an index in the valid range.");
            throw new DeckRangeException();
        }

        return index;
    }

    /**
     * Retrieves deck at index specified in arguments from deckList.
     * getIndex() is used to convert arguments from String to an int index.
     *
     * @param arguments String that contains the ID number of the deck requested
     * @return Reference to requested deck
     * @throws IndexFormatException if arguments is not a digit
     * @throws DeckRangeException if index obtained from arguments is not in range
     */
    private Deck prepareDeck(String arguments)
            throws IndexFormatException, DeckRangeException {

        return deckList.getDeck(getIndex(arguments));
    }

    /**
     * Prepares a deck for being deleted.
     * @param index int representing the index of the deck in deckList
     * @return true if delete is confirmed, otherwise false
     */
    protected boolean prepareDeletedDeck(int index) {
        Deck deck = deckList.getDeck(index);
        logger.log(Level.INFO, "Logging method prepareDeletedDeck() in NormalParser.");
        String response = getDeleteYorNResponse(deck);
        assert (response.equals(Ui.Y) || response.equals(Ui.N)) : "response should be y/n";
        switch (response) {
        case Ui.Y:
            Ui.printDeckDeletedLine(deck.getName());
            Ui.printDashLines();
            return true;
        case Ui.N:
            //
            break;
        default:
            logger.log(Level.SEVERE, "Response should only be either 'Y' or 'N' here");
            //
        }
        return false;
    }

    /**
     * Create a new deck for adding to deckList.
     *
     * @param arguments String that represents the nae of deck to be created
     * @return Reference to the deck created
     * @throws EmptyInputException if no name is supplied for the deck
     */
    protected Deck prepareNewDeck(String arguments) throws EmptyInputException {
        logger.log(Level.INFO, "Logging method prepareNewDeck() in NormalParser.");
        if (arguments.trim().isEmpty()) {
            logger.log(Level.WARNING, "User did not supply name when creating a new deck.");
            throw new EmptyInputException();
        }
        return new Deck(arguments);
    }

    /**
     * Uses Ui to get y or n response from user.
     * @param deck Reference to Deck that is being checked
     * @return Ui.Y if user enters confirms, otherwise Ui.N
     */
    private String getDeleteYorNResponse(Deck deck) {
        logger.log(Level.INFO, "Logging method getDeleteYorNResponse() in NormalParser.");
        String response = "";
        do {
            Ui.printDeletedDeckQuestion(deck.getName());
            response = Ui.readUserInput();
            assert response != null : "response should not be null";
            switch (response.trim()) {
            case Ui.Y:
                response = Ui.Y;
                break;
            case Ui.N:
                response = Ui.N;
                break;
            default:
                logger.log(Level.INFO, "User entered response other than 'y' or 'n'");
                Ui.printInvalidYorNResponse();
                logger.log(Level.INFO, "Re-prompting...");
            }
        } while (!response.trim().equals(Ui.Y) && !response.trim().equals(Ui.N));
        assert (response.equals(Ui.Y) || response.equals(Ui.N)) : "Response should be y/n";
        return response;
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        assert (commandWord != null && arguments != null) :
                "commandWord and arguments should not be null";

        logger.log(Level.INFO, "Logging method parseCommand() in NormalParser.");

        switch (commandWord) {
        // Exit
        case Ui.EXIT:
            logger.log(Level.INFO, "User issued command to terminate program.");
            return new ExitCommand();
        // Edit
        case Ui.EDIT:
            Deck deck = prepareDeck(arguments);
            logger.log(Level.INFO, "User issued command to edit deck " + deck.getName() + ".");
            return new EditCommand(deckList, deck);
        // Create
        case Ui.CREATE:
            Deck newDeck = prepareNewDeck(arguments);
            logger.log(Level.INFO, "User issued command to create deck " + newDeck.getName() + ".");
            return new CreateCommand(deckList, newDeck);
        // Decks
        case Ui.DECKS:
            logger.log(Level.INFO, "User issued command to list decks.");
            return new DecksCommand(deckList);
        // Delete
        case Ui.DELETE:
            int deckID = getIndex(arguments);
            logger.log(Level.INFO, "User issued command to delete deck at index " + deckID);
            boolean isDeckDeleted = prepareDeletedDeck(deckID);
            return new DeleteDeckCommand(deckList, deckID, isDeckDeleted);
        // Help
        case Ui.HELP:
            logger.log(Level.INFO, "User issued command to view help.");
            return new HelpCommand();
        default:
            logger.log(Level.INFO, "User issued an invalid command.");
            return new VoidCommand();
        }
    }

    @Override
    public Command parse(String userInput) {
        logger.log(Level.INFO, "Logging method parse() in NormalParser.");
        String[] splitString = userInput.split(" ", 2);
        String commandWord = splitString[0];
        logger.log(Level.INFO, "Parsed commandWord");
        boolean argumentsExist =  splitString.length > 1;
        String arguments = "";

        if (argumentsExist) {
            arguments = splitString[1];
            logger.log(Level.INFO, "Parsed arguments");
        }

        try {
            logger.log(Level.INFO, "Parsing command");
            return parseCommand(commandWord, arguments);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Parsed void or invalid command");
            return new VoidCommand(e.getMessage());
        }
    }

}
