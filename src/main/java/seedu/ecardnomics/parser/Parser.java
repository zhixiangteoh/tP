package seedu.ecardnomics.parser;

import seedu.ecardnomics.command.Command;

public abstract class Parser {
    public abstract Command parse(String userInput);
}
