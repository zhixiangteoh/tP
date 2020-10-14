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

/**
 * Parser for commands supplied in Normal Mode.
 */
public class NormalParser extends Parser {
    DeckList deckList;

    /** Constructor. */
    public NormalParser(DeckList deckList) {
        this.deckList = deckList;
    }

    @Override
    protected int getIndex(String arguments)
            throws IndexFormatException, DeckRangeException {

        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            throw new IndexFormatException();
        }

        int index = Integer.parseInt(arguments) - Ui.INDEX_OFFSET;

        if ((index >= deckList.size()) || (index < 0)) {
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
        if (arguments.trim().isEmpty()) {
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
                Ui.printInvalidYorNResponse();
            }
        } while (!response.trim().equals(Ui.Y) && !response.trim().equals(Ui.N));
        return response;
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        assert (commandWord != null && arguments != null) :
                "commandWord and arguments should not be null";

        switch (commandWord) {
        // Exit
        case Ui.EXIT:
            return new ExitCommand();
        // Edit
        case Ui.EDIT:
            Deck deck = prepareDeck(arguments);
            return new EditCommand(deckList, deck);
        // Create
        case Ui.CREATE:
            Deck newDeck = prepareNewDeck(arguments);
            return new CreateCommand(deckList, newDeck);
        // Decks
        case Ui.DECKS:
            return new DecksCommand(deckList);
        // Delete
        case Ui.DELETE:
            int deckID = getIndex(arguments);
            boolean isDeckDeleted = prepareDeletedDeck(deckID);
            return new DeleteDeckCommand(deckList, deckID, isDeckDeleted);
        // Help
        case Ui.HELP:
            return new HelpCommand(deckList);
        default:
            return new VoidCommand();
        }
    }

    @Override
    public Command parse(String userInput) {
        String[] splitString = userInput.split(" ", 2);
        String commandWord = splitString[0];
        boolean argumentsExist =  splitString.length > 1;
        String arguments = "";

        if (argumentsExist) {
            arguments = splitString[1];
        }

        try {
            return parseCommand(commandWord, arguments);
        } catch (Exception e) {
            return new VoidCommand(e.getMessage());
        }
    }

}
