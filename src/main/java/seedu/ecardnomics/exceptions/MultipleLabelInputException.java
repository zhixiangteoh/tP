package seedu.ecardnomics.exceptions;

public class MultipleLabelInputException extends Exception {
    public static final String MULTIPLE_LABELS_LINE =
            "You entered multiple labels. Please reenter the command with 1 label.";

    @Override
    public String getMessage() {
        return MULTIPLE_LABELS_LINE;
    }
}
