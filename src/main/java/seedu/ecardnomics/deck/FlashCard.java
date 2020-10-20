package seedu.ecardnomics.deck;

import seedu.ecardnomics.Ui;

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
        return "Question: " + formatResponse("question") + "\n"
                + "   Answer:   " + formatResponse("answer");
    }

    public String toString(String type) {
        assert type.equals("question") || type.equals("answer") : "Only two cases here";
        switch (type) {
        case "question":
            return "Question: " + formatResponse("question");
        case "answer":
            return "Question: " + formatResponse("question") + "\n"
                    + "   Answer:   " + formatResponse("answer");
        default:
            return "";
        }
    }

    /**
     * Format the question and answer response string to properly
     * wrap around the end of each line.
     * IMPORTANT: We assume the following format for printing
     * Questions: "n. Question: [qn]"
     * Answers: "   Answer:   [ans]"
     *
     * @param type String that should only have value "question" or "answer"
     * @return String that stores the formatted question or answer
     */
    private String formatResponse(String type) {
        assert type.equals("question") || type.equals("answer") : "Only two cases here";
        String result = "";
        int startLength;
        String[] words;
        int lineLength = Ui.DASH_LINES.length();

        // We rely on the printing format "n. Question: [qn]"
        // or "   Answer:   [ans]"
        if (type.equals("question")) {
            startLength = "n. Question: ".length();
            words = question.split(" ");;
        } else {
            startLength = "n. Answer:   ".length();
            words = answer.split(" ");
        }
        int usableLength = lineLength - startLength;

        int currentLength = 0;
        for (String word : words) {
            currentLength += word.length();
            if (currentLength > usableLength) {
                // Repeat enough spaces so that text is aligned to usable area.
                result += System.lineSeparator() + " ".repeat(startLength) + word;
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
