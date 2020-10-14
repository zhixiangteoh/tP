package seedu.ecardnomics.deck;

/**
 * Flashcards that contain a question and asnwer.
 */
public class FlashCard {
    private String question;
    private String answer;

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

    @Override
    public String toString() {
        return "Question: " + question + "\n"
                + "   Answer:   " + answer;
    }

    public String toString(String type) {
        switch (type) {
        case "question":
            return "Question: " + question;
        case "answer":
            return "Question: " + question + "\n"
                    + "   Answer:   " + answer;
        default:
            return "";
        }
    }
}
