package seedu.ecardnomics.deck;

public class FlashCard {
    private String question;
    private String answer;

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n"
                + "Answer: " + answer;
    }

    public String toString(String type) {
        switch (type) {
        case "question":
            return "Question: " + question;
        case "answer":
            return "Question: " + question + "\n"
                    + "Answer: " + answer;
        default:
            return "";
        }
    }
}
