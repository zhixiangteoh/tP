package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.deck.AddCommand;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.deck.DeleteCommand;
import seedu.ecardnomics.command.deck.DoneEditCommand;
import seedu.ecardnomics.command.deck.ExitCommand;
import seedu.ecardnomics.command.deck.HelpCommand;
import seedu.ecardnomics.command.deck.ListCommand;
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

        switch (commandWord) {
        // Exit
        case Ui.EXIT:
            return new ExitCommand();
        // Done with Edit Mode
        case Ui.DONE:
            return new DoneEditCommand(deck);
        // Add a FlashCard
        case Ui.ADD:
            return new AddCommand(deck);
        // List all FlashCards
        case Ui.LIST:
            return new ListCommand(deck, arguments);
        // Delete a FlashCard
        case Ui.DELETE:
            return new DeleteCommand(deck, arguments);
        // Help
        case Ui.HELP:
            return new HelpCommand();
        default:
            return new VoidCommand();
        }
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

    public boolean isValidDeckIndex(String arguments) {
        int index = Integer.parseInt(arguments.trim());
        return index > 0 && index <= deck.size();
    }
}
