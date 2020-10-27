package seedu.ecardnomics.deck;

import seedu.ecardnomics.Ui;

/**
 * Flashcards that contain a question and asnwer.
 */
public class FlashCard {
    private String question;
    private String answer;

    private static final String QN_LABEL = "Question: ";
    private static final String ANS_LABEL = "Answer:   ";

    /** Constructor. */
    public FlashCard(String question, String answer) {
        assert (question != null && !question.isEmpty()) : "Flashcard must have one question.";
        this.question = question;
        assert (answer != null && !answer.isEmpty()) : "Flashcard must have one answer";
        this.answer = answer;
    }

    /**
     * Get the answer of the flashcard.
     *
     * @return String representing the answer on the flashcard
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Get the question of the flashcard.
     *
     * @return String representing the question on the flashcard
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set the answer of the flashcard.
     *
     * @param answer new answer on the flashcard
     */
    public void setAnswer(String answer) {
        assert (answer != null && !answer.isEmpty()) : "Flashcard must have one answer";
        this.answer = answer;
    }

    /**
     * Set the question of the flashcard.
     *
     * @param question new answer on the flashcard
     */
    public void setQuestion(String question) {
        assert (question != null && !question.isEmpty()) : "Flashcard must have one question.";
        this.question = question;
    }


    public String toString() {
        return QN_LABEL + formatResponse(true, QN_LABEL.length()) + System.lineSeparator()
                + ANS_LABEL + formatResponse(false, ANS_LABEL.length());
    }

    /**
     * Returns a String that contains the requested details (question or answer)
     * for the flashcard for printing. The String is formatted such that the
     * details will fit between offset characters from the start of the line and
     * Ui.DASH_LINES.length().
     *
     * @param isQuestion indicates whether the required detail is question or answer
     * @param offset Number of characters from the start of the line
     * @return String for displaying question if isQuestion, answer otherwise
     */
    public String toString(boolean isQuestion, int offset) {
        String label = isQuestion ? QN_LABEL : ANS_LABEL;
        String padding = isQuestion ? "" : " ".repeat(offset);
        return padding + label + formatResponse(isQuestion, offset + label.length());
    }

    /**
     * Format the question or answer response string to properly wrap around the end
     * of each line. The response will occupy the area between offset and
     * Ui.DASH_LINES.length().
     *
     * @param isQuestion indicates whether the detail to format is question or answer
     * @param offset Number of characters from the start of the line
     * @return String that stores the formatted question or answer
     */
    private String formatResponse(boolean isQuestion, int offset) {
        String result = "";
        String[] words = isQuestion ? question.split(" ") : answer.split(" ");
        int lineLength = Ui.DASH_LINES.length();
        int usableLength = lineLength - offset;

        int currentLength = 0;
        for (String word : words) {
            // Handle the case where a word is too long to print on one line
            if (word.length() > usableLength) {
                // Find number of characters that can be printed on current line
                int remainLength = usableLength - currentLength;
                result += word.substring(0, remainLength);
                String leftover = word.substring(remainLength);
                // Separate the word into parts that can fit in a line
                while (leftover.length() > usableLength) {
                    result += System.lineSeparator() + " ".repeat(offset)
                            + leftover.substring(0, usableLength);
                    leftover = leftover.substring(usableLength);
                }
                // Place remainder of word into line and continue
                result += System.lineSeparator() + " ".repeat(offset) + leftover + " ";
                currentLength = leftover.length() + 1;
                continue;
            }
            currentLength += word.length();
            if (currentLength > usableLength) {
                // Repeat enough spaces so that text is aligned to usable area.
                result += System.lineSeparator() + " ".repeat(offset) + word;
                currentLength = word.length();
            } else {
                result += word;
            }
            result += " ";
            // Account for the " " after the word.
            ++currentLength;
        }
        return result.trim();
    }
}
