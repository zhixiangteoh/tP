package seedu.ecardnomics.exceptions;

public class FlashCardRangeException extends Exception {
    public static final String FLASHCARD_RANGE_LINE =
            "Index should be within range of number of flash cards";

    @Override
    public String getMessage() {
        return FLASHCARD_RANGE_LINE;
    }
}
