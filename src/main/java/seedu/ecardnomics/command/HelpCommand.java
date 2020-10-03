package seedu.ecardnomics.command;

import seedu.ecardnomics.Ui;

public class HelpCommand extends DeckCommand {
    private final String DECK_HELP = "" +
            "eCardnomics.\n" +
            "Deck Mode.\n" +
            "\n" +
            "Usage:\n" +
            "  add            Adds a new flash card to the current deck.\n" +
            "  list [/ans]    Lists all flash cards in the current deck, optionally with answers.\n" +
            "  delete <ix>    Deletes the flash card at list index <ix> from the current deck.\n" +
            "  help           Show this output.\n" +
            "\n" +
            "Options:\n" +
            "  --version      Show version.";

    public HelpCommand() {
        super();
    }

    @Override
    public void execute() {
        Ui.printDeckHelp(DECK_HELP);
    }
}
