package seedu.ecardnomics.command;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;

public class EditCommand extends NormalCommand {
    Deck deck;

    /** Constructor. */
    public EditCommand(DeckList deckList, Deck deck) {
        super(deckList);
        this.deck = deck;
    }

    @Override
    public void execute() {
        Ui.printDeckWelcome(deckList.getIndexOf(deck) + 1, deck);
    }

    /** Returns Deck which is to be edited. */
    public Deck getDeck() {
        return deck;
    }

    /** Returns if command given is an of instance of <code>EditCommand</code>. */
    public static boolean isEdit(Command command) {
        return command instanceof EditCommand;
    }
}
