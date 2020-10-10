package seedu.ecardnomics.exceptions;

public class EmptyInputException extends Exception {
    public static final String EMPTY_INPUT_LINE =
            "Input shouldn't be empty! Returning...";

    @Override
    public String getMessage() {
        return EMPTY_INPUT_LINE;
    }
}
