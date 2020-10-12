package seedu.ecardnomics.exceptions;

public class DeckRangeException extends Exception {
    public static final String DECK_RANGE_LINE =
            "Index should be within range of number of decks!";

    @Override
    public String getMessage() {
        return DECK_RANGE_LINE;
    }
}
