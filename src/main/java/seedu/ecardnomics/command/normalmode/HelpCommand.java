package seedu.ecardnomics.command.normalmode;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.NormalCommand;
import seedu.ecardnomics.deck.DeckList;

public class HelpCommand extends NormalCommand {
    public static final String NORMAL_HELP = ""
            + "eCardnomics.\n"
            + "Normal Mode.\n"
            + "\n"
            + "Usage:\n"
            + "  create         Creates a new deck of flash cards.\n"
            + "  decks          Lists all available decks.\n"
            + "  edit <ix>      Enter Deck Mode for editing the deck at list index <ix>.\n"
            + "  delete <ix>    Deletes the deck at list index <ix> from list of decks.\n"
            + "  exit           Exits the program.\n"
            + "  help           Show this output.\n"
            + "\n"
            + "Options:\n"
            + "  --version      Show version.";

    public HelpCommand(DeckList deckList) {
        super(deckList);
    }

    @Override
    public void execute() {
        Ui.printHelp(NORMAL_HELP);
    }
}
