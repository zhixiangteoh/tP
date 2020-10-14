package seedu.ecardnomics.command.deck;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;

public class ListCommand extends DeckCommand {
    private final String arguments;

    public static final String TYPE_ANSWER = "answer";
    public static final String TYPE_QUESTION = "question";

    /** Constructor. */
    public ListCommand(Deck deck, String arguments) {
        super(deck);
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        if (arguments.contains("/ans")) {
            Ui.printDeck(currentDeck, TYPE_ANSWER);
        } else {
            Ui.printDeck(currentDeck, TYPE_QUESTION);
        }
    }
}
