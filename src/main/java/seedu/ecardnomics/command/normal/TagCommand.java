package seedu.ecardnomics.command.normal;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.DeckList;

public class TagCommand extends NormalCommand {
    private int index;
    private String[] newTags;

    public TagCommand(DeckList decks, int index, String[] newTags) {
        super(decks);
        this.index = index;
        this.newTags = newTags;
    }

    @Override
    public void execute() {
        deckList.getDeck(index).addTag(newTags);
        Ui.printTags(deckList.getDeck(index).getName(), deckList.getDeck(index).getTag());
    }
}
