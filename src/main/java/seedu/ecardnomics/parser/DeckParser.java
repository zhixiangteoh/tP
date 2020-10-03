package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.AddCommand;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.DoneEditCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.deck.Deck;

public class DeckParser extends Parser {
    public Deck deck;

    /** Constructor. */
    public DeckParser(Deck deck) {
        this.deck = deck;
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        // Exit
        if (commandWord.equals(Ui.EXIT)) {
            return new ExitCommand();
        }

        // Done with Edit Mode
        if (commandWord.equals(Ui.DONE)) {
            return new DoneEditCommand(deck);
        }

        // Add a FlashCard
        if (commandWord.equals(Ui.ADD)) {
            return new AddCommand(deck);
        }

        return new VoidCommand();
    }


    @Override
    public Command parse(String userInput) {
        String[] splitString = userInput.split(" ", 2);
        String commandWord = splitString[0];
        String arguments = "";
        boolean argumentsExist =  splitString.length > 1;

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
