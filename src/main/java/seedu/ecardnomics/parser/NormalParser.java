package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
<<<<<<< HEAD
import seedu.ecardnomics.command.deck.EditCommand;
import seedu.ecardnomics.command.deck.ExitCommand;
=======
import seedu.ecardnomics.command.normal.EditCommand;
>>>>>>> 5c090b433eb3cdca02c4fa46a4d619bfaae66747
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.normal.CreateCommand;
import seedu.ecardnomics.command.normal.DecksCommand;
import seedu.ecardnomics.command.normal.DeleteDeckCommand;
import seedu.ecardnomics.command.normal.HelpCommand;
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

    @Override
    protected int getIndex(String arguments)
            throws IndexFormatException, DeckRangeException {

        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            throw new IndexFormatException();
        }

        int index = Integer.parseInt(arguments) - 1;

        if (index >= deckList.size()) {
            throw new DeckRangeException();
        }

        return index;
    }

    private Deck prepareDeck(String arguments)
            throws IndexFormatException, DeckRangeException {

        return deckList.getDeck(getIndex(arguments));
    }

    private int prepareDeletedDeck(String arguments)
            throws IndexFormatException, DeckRangeException {
        return getIndex(arguments);
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
            Deck newDeck = new Deck(arguments);
            return new CreateCommand(deckList, newDeck);
        // Decks
        case Ui.DECKS:
            return new DecksCommand(deckList);
        // Delete
        case Ui.DELETE:
            int deckID = prepareDeletedDeck(arguments);
            return new DeleteDeckCommand(deckList, deckID);
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
