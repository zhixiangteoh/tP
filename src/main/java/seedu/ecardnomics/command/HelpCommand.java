package seedu.ecardnomics.command;

import seedu.ecardnomics.Ui;

public class HelpCommand extends DeckCommand {
    public static final String DECK_HELP = ""
            + "eCardnomics.\n"
            + "Deck Mode.\n"
            + "\n"
            + "Usage:\n"
            + "  add            Adds a new flash card to the current deck.\n"
            + "  list [/ans]    Lists all flash cards in the current deck, optionally with answers.\n"
            + "  delete <ix>    Deletes the flash card at list index <ix> from the current deck.\n"
            + "  done           Exits from Deck Mode and returns to Normal Mode.\n"
            + "  exit           Exits the program.\n"
            + "  help           Show this output.\n"
            + "\n"
            + "Options:\n"
            + "  --version      Show version.";

    public HelpCommand() {
        super();
    }

    @Override
    public void execute() {
        Ui.printHelp(DECK_HELP);
    }
}
