package seedu.ecardnomics.deck;

import java.util.ArrayList;

/**
 * Deck of flashcards.
 */
public class Deck {
    private String name;
    private ArrayList<FlashCard> deck;

    /** Constructor. */
    public Deck(String name) {
        this.name = name;
        deck = new ArrayList<>();
    }

    /**
     * Gets the name of the deck.
     *
     * @return name of deck
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the deck.
     *
     * @param name new name of the deck
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the flashcard at specified index.
     *
     * @param index Index of flashcard to be found
     * @return
     */
    public FlashCard get(int index) {
        return deck.get(index);
    }

    /**
     * Adds a flashcard to the deck.
     *
     * @param flashCard Reference to the flashcard to be added
     */
    public void add(FlashCard flashCard) {
        deck.add(flashCard);
    }

    /**
     * Returns size of current deck.
     *
     * @return size of current deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Deletes the flashcard at specified index from the deck.
     *
     * @param index Index of flashcard to be deleted
     */
    public void delete(int index) {
        deck.remove(index);
    }

    @Override
    public String toString() {
        String output = name + ":";
        for (int i = 0; i < deck.size(); i++) {
            output += "\n" + (i + 1) + ". " + deck.get(i).toString() + "\n";
        }
        return output;
    }

    public String toString(String type) {
        String output = "";
        if (this.deck.size() == 0) {
            return output;
        }
        for (int i = 0; i < deck.size(); i++) {
            output += (i + 1) + ". " + deck.get(i).toString(type) + "\n" + System.lineSeparator();
        }
        return output;
    }
}
