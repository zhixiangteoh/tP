package seedu.ecardnomics.parser;

import seedu.ecardnomics.Main;
import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.VersionCommand;
import seedu.ecardnomics.command.deck.AddCommand;
import seedu.ecardnomics.command.deck.DeleteCommand;
import seedu.ecardnomics.command.deck.DoneEditCommand;
import seedu.ecardnomics.command.deck.HelpCommand;
import seedu.ecardnomics.command.deck.ListCommand;
import seedu.ecardnomics.command.deck.UpdateCommand;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.exceptions.FlashCardRangeException;
import seedu.ecardnomics.exceptions.IndexFormatException;
import seedu.ecardnomics.deck.FlashCard;
import seedu.ecardnomics.exceptions.EmptyInputException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parser for commands supplied in Deck Mode.
 */
public class DeckParser extends Parser {
    public Deck deck;
    public DeckList deckList;
    private static Logger logger = Logger.getLogger("DeckParserLogger");

    /**
     * Constructor.
     */
    public DeckParser(DeckList deckList, Deck deck) {
        this.deckList = deckList;
        this.deck = deck;
    }

    protected boolean prepareDeletedFlashCard(int flashCardID) {
        logger.log(Level.INFO, "Retrieving flash card at flash card index");
        FlashCard flashCard = deck.get(flashCardID);
        assert flashCard != null : "flash card does not exist!";

        String response = getDeleteYorNResponse(flashCard);
        assert response.equals(Ui.Y) || response.equals(Ui.N) : "response not 'Y' or 'N'!";

        switch (response) {
        case Ui.Y:
            Ui.printFlashCardDeletedLine(flashCard);
            Ui.printDashLines();
            return true;
        case Ui.N:
            //
            break;
        default:
            logger.log(Level.SEVERE, "Response should only be either 'Y' or 'N' here");
            //
        }
        return false;
    }

    /**
     * Verify that a String is contains meaningful contents.
     *
     * @param field String to be verified
     * @throws EmptyInputException if string is empty after trim
     */
    private void verifyStringField(String field) throws EmptyInputException {
        if (field.trim().length() == 0) {
            logger.log(Level.WARNING, "User entered nothing or a series of blank spaces for question");
            throw new EmptyInputException();
        }
    }

    protected String[] prepareFlashCard(String arguments) throws EmptyInputException {
        String[] questionAndAnswer = new String[2];

        if (arguments.contains("/ans")) {
            questionAndAnswer = arguments.split("/ans");
            verifyStringField(questionAndAnswer[0]);
        } else if (!arguments.trim().isEmpty()) {
            // Valid question provided but not answer
            Ui.printAddFlashCardLine(deck);
            Ui.printEnterAnswerLine();
            questionAndAnswer[1] = Ui.readUserInput();
            logger.log(Level.INFO, "Reading user input for answer");
        } else {
            // Ask for both question and answer
            Ui.printAddFlashCardLine(deck);
            Ui.printEnterQuestionLine();
            questionAndAnswer[0] = Ui.readUserInput();
            logger.log(Level.INFO, "Reading user input for question");
            verifyStringField(questionAndAnswer[0]);

            Ui.printEnterAnswerLine();
            questionAndAnswer[1] = Ui.readUserInput();
            logger.log(Level.INFO, "Reading user input for answer");
        }
        verifyStringField(questionAndAnswer[1]);

        assert questionAndAnswer[0].length() > 0 : "question field empty!";
        assert questionAndAnswer[1].length() > 0 : "answer field empty!";

        Ui.printDashLines();
        Ui.printFlashCardAddedLine();
        Ui.printDashLines();

        return questionAndAnswer;
    }

    protected String[] prepareUpdate(int flashCardID) {
        String[] newQnA = new String[2];
        Ui.printUpdateQuestionLine(deck.get(flashCardID));
        newQnA[0] = Ui.readUserInput();
        logger.log(Level.INFO, "Reading user input for question");
        boolean hasNewQ = true;
        boolean hasNewA = true;
        if (newQnA[0].trim().length() == 0) {
            logger.log(Level.INFO, "User entered nothing or a series of blank spaces for question. "
                    + "Keep current question.");
            newQnA[0] = deck.get(flashCardID).getQuestion();
            hasNewQ = false;
        }
        Ui.printUpdateAnswerLine(deck.get(flashCardID));
        newQnA[1] = Ui.readUserInput();
        logger.log(Level.INFO, "Reading user input for answer");
        if (newQnA[1].trim().length() == 0) {
            logger.log(Level.INFO, "User entered nothing or a series of blank spaces for answer. "
                    + "Keep current answer.");
            newQnA[1] = deck.get(flashCardID).getAnswer();
            hasNewA = false;
        }
        assert newQnA[0].length() > 0 : "question field empty!";
        assert newQnA[1].length() > 0 : "answer field empty!";
        Ui.printFlashCardUpdatedLine(hasNewQ, hasNewA);
        Ui.printDashLines();
        return newQnA;
    }

    @Override
    protected int getIndex(String arguments) throws IndexFormatException, FlashCardRangeException {

        arguments = arguments.trim();

        if (!arguments.matches(Ui.DIGITS_REGEX)) {
            logger.log(Level.WARNING, "User did not enter valid integer");
            throw new IndexFormatException();
        }

        assert arguments.length() > 0 : "arguments empty!";

        int index = Integer.parseInt(arguments) - INDEX_OFFSET;

        if (index >= deck.size() || index < LOWEST_POSSIBLE_INDEX) {
            logger.log(Level.WARNING, "Flash card index larger than total number of cards");
            throw new FlashCardRangeException();
        }
        return index;
    }

    protected String getDeleteYorNResponse(FlashCard flashCard) {
        logger.log(Level.INFO, "Prompting user for 'Y' or 'N' response");
        String response = "";

        Ui.printDashLines();
        do {
            Ui.printDeleteFlashCardLine(flashCard);
            response = Ui.readUserInput();
            switch (response.trim()) {
            case Ui.Y:
                response = Ui.Y;
                break;
            case Ui.N:
                response = Ui.N;
                break;
            default:
                logger.log(Level.INFO, "User entered response other than 'Y' or 'N'");
                Ui.printInvalidYorNResponse();
                logger.log(Level.INFO, "Re-prompting...");
            }
        } while (!response.trim().equals(Ui.Y) && !response.trim().equals(Ui.N));
        assert response.length() == 1 : "response is not 'Y' or 'N'!";
        return response;
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        switch (commandWord) {
        // Version
        case Ui.VERSION_CMD:
            return new VersionCommand();
        // Exit
        case Ui.EXIT:
            logger.log(Level.INFO, "returning ExitCommand object");
            return new ExitCommand();
        // Done with Edit Mode
        case Ui.DONE:
            logger.log(Level.INFO, "returning DoneEditCommand object");
            return new DoneEditCommand(deck);
        // Help
        case Ui.HELP:
            logger.log(Level.INFO, "returning HelpCommand object");
            return new HelpCommand();
        // Start
        case Ui.START:
            logger.log(Level.INFO, "Starting Game Mode");
            System.out.println(deckList.getIndexOf(deck));
            return new NormalParser(Main.deckList).parseCommand(commandWord,
                    String.valueOf(deckList.getIndexOf(deck) + 1));
        // Add a FlashCard
        case Ui.ADD:
            logger.log(Level.INFO, "Preparing FlashCard to add");
            String[] questionAndAnswer = prepareFlashCard(arguments);
            logger.log(Level.INFO, "returning AddCommand object");
            return new AddCommand(deck, questionAndAnswer[0], questionAndAnswer[1]);
        // List all FlashCards
        case Ui.LIST:
            logger.log(Level.INFO, "returning ListCommand object");
            return new ListCommand(deck, arguments);
        // Delete a FlashCard
        case Ui.DELETE:
            logger.log(Level.INFO, "Preparing FlashCard to delete");
            int flashCardID = getIndex(arguments);
            assert flashCardID >= LOWEST_POSSIBLE_INDEX : "flash card ID less than lowest possible flash card index!";
            boolean isFlashCardDeleted = prepareDeletedFlashCard(flashCardID);
            logger.log(Level.INFO, "returning DeleteCommand object");
            return new DeleteCommand(deck, flashCardID, isFlashCardDeleted);
        // Update a FlashCard
        case Ui.UPDATE:
            logger.log(Level.INFO, "Preparing FlashCard to update");
            flashCardID = getIndex(arguments);
            assert flashCardID >= LOWEST_POSSIBLE_INDEX : "flash card ID less than lowest possible flash card index!";
            String[] newQnA = prepareUpdate(flashCardID);
            return new UpdateCommand(deck, flashCardID, newQnA[0], newQnA[1]);
        // Create PowerPoint
        case Ui.PPTX:
            logger.log(Level.INFO, "Printing to PowerPoint");
            return new NormalParser(Main.deckList).parseCommand(commandWord,
                    (deckList.getIndexOf(deck) + 1) + " " + arguments);
        default:
            logger.log(Level.WARNING, "returning VoidCommand object");
            return new VoidCommand();
        }
    }

    @Override
    public Command parse(String userInput) {
        logger.log(Level.INFO, "Parsing user input string");
        String[] splitString = userInput.split(" ", 2);
        String commandWord = splitString[0];
        logger.log(Level.INFO, "Parsed commandWord");
        String arguments = "";
        boolean argumentsExist = splitString.length > 1;
        if (argumentsExist) {
            arguments = splitString[1];
            logger.log(Level.INFO, "Parsed arguments");
        }
        try {
            logger.log(Level.INFO, "Parsing command");
            return parseCommand(commandWord, arguments);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Parsed void or invalid command");
            return new VoidCommand(e.getMessage());
        }
    }
}
