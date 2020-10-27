package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

import java.util.ArrayList;

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
<<<<<<< HEAD
        assert  (removedTags.length != 0) : "Remove tags must be provided.";
=======
        assert  (removedTags.length != 0): "Removed tags must be provided.";
>>>>>>> trang-tag
        this.removedTags = removedTags;
    }

    @Override
    public void execute() {
        String deckName = deckList.getDeck(index).getName();
        boolean isTagsValid = checkTagsExist(removedTags);

        if (isTagsValid) {
            boolean isTagsRemoved = Ui.getRemovedTagsConfirmation(removedTags, deckName);
            if (isTagsRemoved) {
                deckList.getDeck(index).removeTag(removedTags);
            }
        }
    }

    public boolean checkTagsExist(String[] removedTags) {
        boolean isExist = true;
        ArrayList<String> availableTagList = deckList.getDeck(index).getTag();
        for (String removedTag : removedTags) {
            if (!availableTagList.contains(removedTag)) {
                isExist = false;
                Ui.printInvalidTagsLine();
                break;
            }
        }
        return isExist;
    }

}
