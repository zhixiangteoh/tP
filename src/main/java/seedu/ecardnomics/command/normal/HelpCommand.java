package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class HelpCommand extends NormalCommand {
    public static final String NORMAL_HELP = ""
            + "eCardnomics.\n"
            + "Normal Mode.\n"
            + "\n"
            + "Usage:\n"
            + "  create <nm>    Creates a new deck of flash cards, named <nm>.\n"
            + "  decks          Lists all available decks.\n"
            + "  edit <ix>      Enter Deck Mode for editing the deck at list index <ix>.\n"
            + "  start <ix>     Enter Game Mode for deck at list index <ix>! Do your best!\n"
            + "  delete <ix>    Deletes the deck at list index <ix> from list of decks.\n"
            + "  pptx <ix> [-y] Creates a PowerPoint slides based on the deck at list index <ix>.\n"
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
        Ui.printHelp(NORMAL_HELP);
    }
}
