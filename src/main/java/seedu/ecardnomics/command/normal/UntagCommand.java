package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

/**
 * Removes tags from the existing deck.
 */
public class UntagCommand extends NormalCommand {
    private int index;
    private String[] removedTags;

    /** Constructor. */
    public UntagCommand(DeckList decks, int index, String[] removedTags) {
        super(decks);
        assert (index >= 0 && index < decks.size()) : "Index must be within range.";
        this.index = index;
        assert  (removedTags.length != 0): "Remove tags must be provided.";
        this.removedTags = removedTags;
    }

    @Override
    public void execute() {
        String deckName = deckList.getDeck(index).getName();
        boolean isTagsRemoved = Ui.getRemovedTagsConfirmation(removedTags, deckName);

        if (isTagsRemoved) {
            deckList.getDeck(index).removeTag(removedTags);
        }
    }

}
