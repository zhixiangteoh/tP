package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.powerpoint.PowerPoint;

public class PowerPointCommand extends NormalCommand {
    Deck deck;
    PowerPoint pptx;
    boolean isPpptxCreated;

    /** Constructor. */
    public PowerPointCommand(DeckList deckList, Deck deck, boolean isPpptxCreated) {
        super(deckList);
        assert deck != null : "Do not operate on a null reference.";
        this.deck = deck;
        pptx = new PowerPoint(deck);
        this.isPpptxCreated = isPpptxCreated;
    }

    @Override
    public void execute() {
        if (isPpptxCreated) {
            pptx.createNewPowerPoint();
        }
    }
}
