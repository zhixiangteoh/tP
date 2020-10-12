package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.command.Command;
<<<<<<< HEAD:src/main/java/seedu/ecardnomics/command/normal/NormalCommand.java
import seedu.ecardnomics.deck.Deck;
=======
>>>>>>> upstream1/master:src/main/java/seedu/ecardnomics/command/NormalCommand.java
import seedu.ecardnomics.deck.DeckList;

public abstract class NormalCommand extends Command {
    protected DeckList deckList;

    public NormalCommand(DeckList deckList) {
        this.deckList = deckList;
    }

    public abstract void execute();
}
