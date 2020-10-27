package seedu.ecardnomics.parser;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.VersionCommand;
import seedu.ecardnomics.command.VoidCommand;
import seedu.ecardnomics.command.normal.CreateCommand;
import seedu.ecardnomics.command.normal.DecksCommand;
import seedu.ecardnomics.command.normal.DeleteDeckCommand;
import seedu.ecardnomics.command.normal.EditCommand;
import seedu.ecardnomics.command.normal.HelpCommand;
import seedu.ecardnomics.command.normal.PowerPointCommand;
import seedu.ecardnomics.command.normal.StartCommand;
import seedu.ecardnomics.command.normal.TagCommand;
import seedu.ecardnomics.command.normal.UntagCommand;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.exceptions.DeckRangeException;
import seedu.ecardnomics.exceptions.EmptyInputException;
import seedu.ecardnomics.exceptions.IndexFormatException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parser for commands supplied in Normal Mode.
 */
public class NormalParser extends Parser {
    DeckList deckList;
    private static Logger logger = Logger.getLogger("NormalParserLogger");

    /** Constructor. */
    public NormalParser(DeckList deckList) {
        this.deckList = deckList;
    }

    @Override
    protected int getIndex(String arguments) throws IndexFormatException, DeckRangeException {

        String indexString = arguments.trim();

        logger.log(Level.INFO, "Logging method getIndex() in NormalParser.");
        if (!indexString.matches(Ui.DIGITS_REGEX)) {
            logger.log(Level.WARNING, "User did not enter a valid integer index.");
            throw new IndexFormatException();
        }

        int index = Integer.parseInt(indexString) - INDEX_OFFSET;

        if ((index >= deckList.size()) || (index < LOWEST_POSSIBLE_INDEX)) {
            logger.log(Level.WARNING, "User did not enter an index in the valid range.");
            throw new DeckRangeException();
        }

        return index;
    }

    /**
     * Retrieves deck at index specified in arguments from deckList.
     * getIndex() is used to convert arguments from String to an int index.
     *
     * @param arguments String that contains the ID number of the deck requested
     * @return Reference to requested deck
     * @throws IndexFormatException if arguments is not a digit
     * @throws DeckRangeException if index obtained from arguments is not in range
     */
    private Deck prepareDeck(String arguments)
            throws IndexFormatException, DeckRangeException {

        return deckList.getDeck(getIndex(arguments));
    }

    /**
     * Prepares a deck for being deleted.
     * @param index int representing the index of the deck in deckList
     * @return true if delete is confirmed, otherwise false
     */
    protected boolean getDeletedDeckConfirmation(int index) {
        Deck deck = deckList.getDeck(index);
        logger.log(Level.INFO, "Logging method getDeletedDeckConfirmation() in NormalParser.");

        Ui.printDeletedDeckQuestion(deck.getName());

        String response = checkYorNResponse();
        assert (response.equals(Ui.Y) || response.equals(Ui.N)) : "response should be y/n";

        switch (response) {
        case Ui.Y:
            Ui.printDeckDeletedLine(deck.getName());
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
     * Checks whether the user want to remove the tags specified
     * from the deck specified.
     *
     * @param tags String[] representing the tags be removed
     * @param id int representing the index of the deck of the tags
     * @return true if the removal is confirmed, otherwise false
     */
    protected boolean getRemovedTagsConfirmation(String[] tags, int id) {
        Deck deck = deckList.getDeck(id);

        Ui.printRemovedTagsQuestion(deck.getName(), tags);
        String response = checkYorNResponse();

        switch (response) {
        case Ui.Y:
            Ui.printTagsRemovedLine(deck.getName(), tags);
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
     * Creates a new deck for adding to deckList.
     *
     * @param arguments String that represents the nae of deck to be created
     * @return Reference to the deck created
     * @throws EmptyInputException if no name is supplied for the deck
     */
    protected Deck prepareNewDeck(String arguments) throws EmptyInputException {
        logger.log(Level.INFO, "Logging method prepareNewDeck() in NormalParser.");
        if (arguments.trim().isEmpty()) {
            logger.log(Level.WARNING, "User did not supply name when creating a new deck.");
            throw new EmptyInputException();
        }

        if (arguments.contains("/tag")) {
            ArrayList<String> tagsList = new ArrayList<>();
            String[] nameAndTags = arguments.split("/tag", 2);
            String name = nameAndTags[0].trim();
            String[] tags = nameAndTags[1].trim().split(" ");
            for (String tag: tags) {
                tagsList.add(tag);
            }
            return new Deck(name, tagsList);
        } else {
            return new Deck(arguments);
        }
    }

    /**
     * Checks y or n response from user.
     * @return Ui.Y if user enters confirms, otherwise Ui.N
     */
    private String checkYorNResponse() {
        logger.log(Level.INFO, "Logging method checkYorNResponse() in NormalParser.");
        Ui.printDashLines();

        String response = "";

        do {
            response = Ui.readUserInput();
            assert response != null : "response should not be null";
            switch (response.trim()) {
            case Ui.Y:
                response = Ui.Y;
                break;
            case Ui.N:
                response = Ui.N;
                break;
            default:
                logger.log(Level.INFO, "User entered response other than 'y' or 'n'");
                Ui.printInvalidYorNResponse();
                logger.log(Level.INFO, "Re-prompting...");
            }
        } while (!response.trim().equals(Ui.Y) && !response.trim().equals(Ui.N));
        assert (response.equals(Ui.Y) || response.equals(Ui.N)) : "Response should be y/n";
        return response;
    }


    /**
     * Prepares a deck to be printed to PowerPoint.
     * @param index int representing the index of the deck in deckList
     * @return true if delete is confirmed, otherwise false
     */
    protected boolean getPptxDeckConfirmation(int index) {
        Deck deck = deckList.getDeck(index);
        logger.log(Level.INFO, "Logging method getPptxDeckConfirmation() in NormalParser.");

        Ui.printPptxDeckQuestion(deck.getName());

        String response = checkYorNResponse();
        assert (response.equals(Ui.Y) || response.equals(Ui.N)) : "response should be y/n";

        switch (response) {
        case Ui.Y:
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

    private PowerPointCommand preparePptxDeck(String arguments) throws Exception {
        if (arguments.contains("-y")) {
            arguments = arguments.replaceAll("-y", "");
            return new PowerPointCommand(deckList, prepareDeck(arguments), true);
        }
        int deckID = getIndex(arguments);
        boolean isPptxCreated = getPptxDeckConfirmation(deckID);
        return new PowerPointCommand(deckList, deckList.getDeck(deckID), isPptxCreated);
    }

    @Override
    protected Command parseCommand(String commandWord, String arguments)
            throws Exception {

        assert (commandWord != null && arguments != null) :
                "commandWord and arguments should not be null";

        logger.log(Level.INFO, "Logging method parseCommand() in NormalParser.");

        switch (commandWord) {
        // Version
        case Ui.VERSION_CMD:
            return new VersionCommand();
        // Exit
        case Ui.EXIT:
            logger.log(Level.INFO, "User issued command to terminate program.");
            return new ExitCommand();
        // Help
        case Ui.HELP:
            logger.log(Level.INFO, "User issued command to view help.");
            return new HelpCommand();
        // Edit
        case Ui.EDIT:
            Deck deck = prepareDeck(arguments);
            logger.log(Level.INFO, "User issued command to edit deck " + deck.getName() + ".");
            return new EditCommand(deckList, deck);
        // Start
        case Ui.START:
            Deck startDeck = prepareDeck(arguments);
            logger.log(Level.INFO, "User issued command to start deck " + startDeck.getName() + ".");
            return new StartCommand(deckList, startDeck);
        // Create
        case Ui.CREATE:
            Deck newDeck = prepareNewDeck(arguments);
            logger.log(Level.INFO, "User issued command to create deck " + newDeck.getName() + ".");
            return new CreateCommand(deckList, newDeck);
        // Decks
        case Ui.DECKS:
            logger.log(Level.INFO, "User issued command to list decks.");
            return new DecksCommand(deckList);
        // Delete
        case Ui.DELETE:
            int deckID = getIndex(arguments);
            logger.log(Level.INFO, "User issued command to delete deck at index " + deckID);
            boolean isDeckDeleted = getDeletedDeckConfirmation(deckID);
            return new DeleteDeckCommand(deckList, deckID, isDeckDeleted);
        // Tag
        case Ui.TAG:
            logger.log(Level.INFO, "User issued command to tag a deck.");
            assert (arguments.contains("/tag")) :
                    "tags to be added are after /tag label";
            String[] idAndNewTags = arguments.split("/tag");
            deckID = getIndex(idAndNewTags[0]);
            String[] newTags = idAndNewTags[1].trim().split(" ");
            return new TagCommand(deckList, deckID, newTags);
        // Untag
        case Ui.UNTAG:
            logger.log(Level.INFO, "User issued command to untag a deck.");
            assert (arguments.contains("/tag")) :
                    "tags to be removed are after /tag label";
            String[] idAndDeletedTags = arguments.split("/tag");
            deckID = getIndex(idAndDeletedTags[0]);
            String[] deletedTags = idAndDeletedTags[1].trim().split(" ");
            boolean isTagsRemoved = getRemovedTagsConfirmation(deletedTags, deckID);
            return new UntagCommand(deckList, deckID, deletedTags, isTagsRemoved);
        // Create new PowerPoint
        case Ui.PPTX:
            logger.log(Level.INFO, "User issued command to create a PowerPoint.");
            return preparePptxDeck(arguments);
        default:
            logger.log(Level.INFO, "User issued an invalid command.");
            return new VoidCommand();
        }
    }

    @Override
    public Command parse(String userInput) {
        logger.log(Level.INFO, "Logging method parse() in NormalParser.");
        String[] splitString = userInput.split(" ", 2);
        String commandWord = splitString[0];
        logger.log(Level.INFO, "Parsed commandWord");
        boolean argumentsExist =  splitString.length > 1;
        String arguments = "";

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
