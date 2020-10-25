package seedu.ecardnomics.exceptions;

public class EmptyDeckException extends Exception {
    public static final String EMPTY_DECK_LINE =
            "Deck is empty! Please add some flash cards first.";

    @Override
    public String getMessage() {
        return EMPTY_DECK_LINE;
    }
}
