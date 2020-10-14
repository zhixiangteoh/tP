package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.deck.DeleteCommand;
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

    private Deck prepareDeck(String arguments)
            throws IndexFormatException, DeckRangeException {

        return deckList.getDeck(getIndex(arguments));
    }

    protected boolean prepareDeletedDeck(int index) {
        Deck deck = deckList.getDeck(index);
        String response = getDeleteYorNResponse(deck);
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

    protected Deck prepareNewDeck(String arguments) throws EmptyInputException {
        if (arguments.trim().isEmpty()) {
            throw new EmptyInputException();
        }
        return new Deck(arguments);
    }

    private String getDeleteYorNResponse(Deck deck) {
        String response = "";
        do {
            Ui.printDeletedDeckQuestion(deck.getName());
            response = Ui.readUserInput();
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
