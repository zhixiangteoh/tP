package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

/**
 * Removes tags from the existing deck.
 */
public class UntagCommand extends NormalCommand {
    private int index;
    private String[] removedTags;
    private boolean isTagsRemoved;

    /** Constructor. */
    public UntagCommand(DeckList decks, int index, String[] removedTags, boolean isTagsRemoved) {
        super(decks);
        assert (index >= 0 && index < decks.size()) : "Index must be within range.";
        this.index = index;
        this.removedTags = removedTags;
        this.isTagsRemoved = isTagsRemoved;
    }

    @Override
    public void execute() {
        if (isTagsRemoved) {
            deckList.getDeck(index).removeTag(removedTags);
        }
    }
}
