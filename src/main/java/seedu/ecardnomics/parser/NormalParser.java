package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.EditCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.VoidCommand;
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

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        // Edit
        if (commandWord.equals(Ui.EDIT)) {
            Deck deck = prepareDeck(arguments);
            return new EditCommand(deckList, deck);
        }

        // Exit
        if (commandWord.equals(Ui.EXIT)) {
            return new ExitCommand();
        }

        return new VoidCommand();
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
