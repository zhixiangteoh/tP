package seedu.ecardnomics.parser;

import seedu.ecardnomics.command.Command;

public abstract class Parser {

    /**
     * Checks whether argument from user is a number and whether the index given is a within the correct range of
     * decks/ flash cards.
     *
     * @param arguments Argument from user input
     * @return int representing the index from the argument given
     */
    protected abstract int getIndex(String arguments)
            throws Exception;

    protected abstract Command parseCommand(String commandWord, String arguments)
            throws Exception;

    /**
     * Parse user input to determine which <code>Command</code> to output.
     *
     * @param userInput Input from user
     * @return Command representing command to be executed
     */
    public abstract Command parse(String userInput);
}
