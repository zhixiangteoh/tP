package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.deckmode.EditCommand;
import seedu.ecardnomics.command.deckmode.ExitCommand;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.normalmode.CreateCommand;
import seedu.ecardnomics.command.normalmode.DecksCommand;
import seedu.ecardnomics.command.normalmode.DeleteDeckCommand;
import seedu.ecardnomics.command.normalmode.HelpCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.exceptions.DeckRangeException;
import seedu.ecardnomics.exceptions.IndexFormatException;

public class NormalParser extends Parser {
    DeckList deckList;

    /** Constructor. */
    public NormalParser(DeckList deckList) {
        this.deckList = deckList;
    }

    private Deck prepareDeck(String arguments)
            throws IndexFormatException, DeckRangeException {

        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            throw new IndexFormatException();
        }

        int index = Integer.parseInt(arguments) - 1;

        if (index >= deckList.size()) {
            throw new DeckRangeException();
        }

        return deckList.getDeck(index);
    }

    private int prepareDeletedDeck(String arguments) throws IndexFormatException, DeckRangeException {

        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            throw new IndexFormatException();
        }

        int deckID = Integer.parseInt(arguments);

        if (deckID > deckList.size()) {
            throw new DeckRangeException();
        }

        return deckID;
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        switch (commandWord) {
        // Edit
        case Ui.EDIT:
            Deck deck = prepareDeck(arguments);
            return new EditCommand(deckList, deck);

        // Help
        case Ui.HELP:
            return new HelpCommand(deckList);

        // Exit
        case Ui.EXIT:
            return new ExitCommand();

        // Create
        case Ui.CREATE:
            Deck newDeck = new Deck(arguments);
            return new CreateCommand(deckList, newDeck);

        // Decks
        case Ui.DECKS:
            return new DecksCommand(deckList);

        // Delete
        case Ui.DELETE:
            int deckID = prepareDeletedDeck(arguments);
            return new DeleteDeckCommand(deckList, deckID);

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
