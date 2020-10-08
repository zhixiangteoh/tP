package seedu.ecardnomics.command.deck;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.DeckCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.FlashCard;
import seedu.ecardnomics.parser.DeckParser;

public class DeleteCommand extends DeckCommand {
    private final String arguments;
    private final DeckParser deckParser;

    public DeleteCommand(Deck deck, String arguments) {
        super(deck);
        this.arguments = arguments;
        deckParser = new DeckParser(deck);
    }

    @Override
    public void execute() {
        try {
            int index = Integer.parseInt(arguments) - 1;
            FlashCard flashCard = currentDeck.get(index);

            Ui.printDeleteFlashCardLine(flashCard);
            final String yn = Ui.readUserInput();
            switch (yn) {
            case "y":
                Ui.printFlashCardDeletedLine(flashCard);
                Ui.printDashLines();
                currentDeck.delete(index);
                break;
            case "n":
                //
                break;
            default:
                //
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
