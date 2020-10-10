package seedu.ecardnomics.exceptions;

public class QuestionRangeException extends Exception {
    public static final String QUESTION_RANGE_LINE =
            "Index should be within range of number of flash cards";

    @Override
    public String getMessage() {
        return QUESTION_RANGE_LINE;
    }
}
