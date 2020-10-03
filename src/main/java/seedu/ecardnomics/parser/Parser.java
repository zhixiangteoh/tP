package seedu.ecardnomics.parser;

import seedu.ecardnomics.command.Command;

public abstract class Parser {

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
