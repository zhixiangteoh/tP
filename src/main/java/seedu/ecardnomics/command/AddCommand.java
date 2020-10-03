package seedu.ecardnomics.command;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.FlashCard;

public class AddCommand extends DeckCommand {

    /** Constructor. */
    public AddCommand(Deck deck) {
        super(deck);
    }

    @Override
    public void execute() {
        Ui.printAddFlashCardLine(currentDeck);
        Ui.printEnterQuestionLine();
        final String question = Ui.readUserInput();
        Ui.printEnterAnswerLine();
        final String answer = Ui.readUserInput();
        Ui.printFlashCardAddedLine();
        Ui.printDashLines();

        this.currentDeck.add(new FlashCard(question, answer));
    }
}
