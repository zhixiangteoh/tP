package seedu.ecardnomics.exceptions;


public class DeckRangeException extends Exception {
    public static final String INDEX_RANGE_LINE =
            "Index should be within range of number of tasks";

    @Override
    public String getMessage() {
        return INDEX_RANGE_LINE;
    }
}
