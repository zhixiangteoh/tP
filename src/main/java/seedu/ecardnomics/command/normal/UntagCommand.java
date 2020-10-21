package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class UntagCommand extends NormalCommand {
    private int index;
    private String[] removedTags;
    private boolean isTagsRemoved;

    public UntagCommand(DeckList decks, int index, String[] deletedTags, boolean isTagsRemoved) {
        super(decks);
        this.index = index;
        this.removedTags = deletedTags;
        this.isTagsRemoved = isTagsRemoved;
    }

    @Override
    public void execute() {
        if (isTagsRemoved) {
            deckList.getDeck(index).removeTag(removedTags);
        }
    }
}
