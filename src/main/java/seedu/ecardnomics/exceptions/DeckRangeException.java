package seedu.ecardnomics.exceptions;


public class DeckRangeException extends Exception {
    public static final String INDEX_RANGE_LINE =
            "Index should be within range of list!";

    @Override
    public String getMessage() {
        return INDEX_RANGE_LINE;
    }
}
