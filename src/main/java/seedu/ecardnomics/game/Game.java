package seedu.ecardnomics.game;

import seedu.ecardnomics.command.Command;
import seedu.ecardnomics.deck.Deck;

public class Game {
    GameStorage storage;
    GameEngine engine;

    public Game(Deck deck) {
        storage = new GameStorage(deck);
        engine = new GameEngine(storage);
    }

    public Command run() {
        return engine.runGameLoop();
    }
}
