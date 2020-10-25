package seedu.ecardnomics.game;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.command.ExitCommand;
import seedu.ecardnomics.command.VersionCommand;
import seedu.ecardnomics.command.game.DoneGameCommand;
import seedu.ecardnomics.command.game.GameResponseCommand;
import seedu.ecardnomics.command.game.HelpCommand;
import seedu.ecardnomics.deck.FlashCard;
import seedu.ecardnomics.parser.GameParser;

public class GameEngine {
    GameStorage storage;
    GameParser gameParser;

    GameEngine(GameStorage storage) {
        gameParser = new GameParser(storage.originalDeck);
        this.storage = storage;
    }

    Command runGameLoop() {
        Command command;

        do {
            FlashCard flashCard = getQuestion();
            do {
                poseQuestion(flashCard);
                command = getAttempt();
                if (isHelpCommand(command) || isVersionCommand(command)) {
                    command.execute();
                }
            } while (isHelpCommand(command) || isVersionCommand(command));
            if (isTerminate(command)) {
                break;
            }
            Ui.printAnswerGameMode(flashCard.getAnswer());
            try {
                Ui.printAttemptFeedback(checkResponse(command, flashCard));
            } catch (Exception e) {
                e.getMessage();
            }
            command = update(getInclExclYorNResponse(), flashCard, command);

        } while (!isTerminate(command) && !isNoMoreCards());

        return command;
    }

    Command update(String response, FlashCard flashCard, Command command) {
        assert !isTerminate(command) : "Command is either `done` or `exit` when it shouldn't be!";

        updateRetestStore(response, flashCard);

        if (storage.deque.isEmpty()) {
            if (storage.retestStore.isEmpty()) {
                Ui.printDoneGameMessage();
                return gameParser.parse("done");
            } else {
                updateDeque();
            }
        }

        return null;
    }

    void updateDeque() {
        storage.deque = storage.createRandomisedStack(storage.retestStore);
        storage.refreshRetestStore();
    }

    void updateRetestStore(String response, FlashCard flashCard) {
        switch (response) {
        // include
        case Ui.Y:
            if (!storage.retestStore.contains(flashCard)) {
                storage.retestStore.add(flashCard);
            }
            break;
        // exclude
        case Ui.N:
            if (!storage.retestStore.contains(flashCard)) {
                storage.retestStore.remove(flashCard);
            }
            break;
        default:
            //
        }
    }

    FlashCard getQuestion() {
        return storage.deque.pop();
    }

    void poseQuestion(FlashCard flashCard) {
        Ui.printGameQuestion(flashCard.getQuestion());
    }

    String getInclExclYorNResponse() {
        return gameParser.getInclExclYorNResponse();
    }

    Command getAttempt() {
        String userInput = Ui.readUserInput();
        Command command = gameParser.parse(userInput);
        return command;
    }

    double checkResponse(Command command, FlashCard flashCard) throws Exception {
        if (!(command instanceof GameResponseCommand)) {
            throw new Exception();
        }
        String attempt = ((GameResponseCommand) command).getAttempt();
        String answer = flashCard.getAnswer();

        return getMatchPercentage(attempt, answer);
    }

    double getMatchPercentage(String attempt, String answer) {
        String[] attemptArray = attempt.replaceAll("\\p{Punct}","").split(" ");
        String[] answerArray = answer.replaceAll("\\p{Punct}","").split(" ");
        int answerLength = answerArray.length;
        int matchCount = 0;
        for (String word1 : answerArray) {
            for (String word2: attemptArray) {
                if (word2.equalsIgnoreCase(word1)) {
                    matchCount++;
                    break;
                }
            }
        }

        if (answerLength == 0) {
            return 0;
        }
        assert matchCount <= answerLength : "matchCount > answerLength!";
        return (double) matchCount / answerLength * 100;
    }

    boolean isTerminate(Command command) {
        return DoneGameCommand.isDoneGame(command) || ExitCommand.isExit(command);
    }

    boolean isNoMoreCards() {
        return storage.deque.isEmpty() && storage.retestStore.isEmpty();
    }

    boolean isHelpCommand(Command command) {
        return command instanceof HelpCommand;
    }

    boolean isVersionCommand(Command command) {
        return command instanceof VersionCommand;
    }
}
