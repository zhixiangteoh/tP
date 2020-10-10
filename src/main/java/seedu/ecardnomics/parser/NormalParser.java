package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.normal.EditCommand;
import seedu.ecardnomics.command.deck.ExitCommand;
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

    private boolean verifyDeleteDeck(int index) {
        String nameDeletedDeck = deckList.getDeck(index).getName();
        Ui.printDeletedDeckQuestion(nameDeletedDeck);
        String answer = Ui.readUserInput();

        switch (answer) {
        case "y":
            return true;
        case "n":
        default:
            return false;
        }
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
            int index = getIndex(arguments);
            boolean isVerified = verifyDeleteDeck(index);
            return new DeleteDeckCommand(deckList, index, isVerified);
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
