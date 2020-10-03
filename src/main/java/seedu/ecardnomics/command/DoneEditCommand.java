package seedu.ecardnomics.command;

import seedu.ecardnomics.deck.Deck;

public class DoneEditCommand extends DeckCommand{

    public DoneEditCommand(Deck deck){
        super(deck);
    }

    @Override
    public void execute(){
    }

    public static boolean isDoneEdit(Command command){
        return command instanceof DoneEditCommand;
    }
}
