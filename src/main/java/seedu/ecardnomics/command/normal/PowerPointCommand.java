package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.powerpoint.PowerPoint;

public class PowerPointCommand extends NormalCommand {
    Deck deck;
    PowerPoint pptx;

    /** Constructor */
    public PowerPointCommand(DeckList deckList, Deck deck) {
        super(deckList);
        assert deck != null : "Do not operate on a null reference.";
        this.deck = deck;
        pptx = new PowerPoint(deck);
    }

    @Override
    public void execute() {
        pptx.createNewPowerPoint();
    }
}
