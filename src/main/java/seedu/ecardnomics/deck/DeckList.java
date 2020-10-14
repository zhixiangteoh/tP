package seedu.ecardnomics.deck;

import java.util.ArrayList;

/**
 * List for storing decks.
 */
public class DeckList {
    private ArrayList<Deck> deckList;

    /** Constructor. */
    public DeckList() {
        deckList = new ArrayList<>();
    }

    /**
     * Adds a deck to the list.
     *
     * @param deck reference to Deck to be added
     */
    public void addDeck(Deck deck) {
        assert deck != null : "Do not add null object to list.";
        deckList.add(deck);
    }

    /**
     * Removes a deck from the list.
     *
     * @param index int representing index of deck to to be removed
     */
    public void removeDeck(int index) {
        assert (index >= 0 && index < deckList.size()) : "Index should be within range.";
        deckList.remove(index);
    }

    /**
     * Returns size of current list.
     *
     * @return size of list
     */
    public int size() {
        return deckList.size();
    }

    /**
     * Returns a deck from deck list based on given index.
     *
     * @param index Index of deck to be found
     * @return Deck found at <code>index</code>
     */
    public Deck getDeck(int index) {
        assert (index >= 0 && index < deckList.size()) : "Index should be within range.";
        return deckList.get(index);
    }


    /**
     * Returns index of deck in deck list.
     *
     * @param deck Deck which index is to be found
     * @return Index found of <code>deck</code>
     */
    public int getIndexOf(Deck deck) {
        assert deck != null : "Do not try to get index of a null reference.";
        return deckList.indexOf(deck);
    }

    @Override
    public String toString() {
        String output = "Decks:";
        for (int i = 0; i < deckList.size(); i++) {
            output += "\n" + (i + 1) + ". " + deckList.get(i).getName();
        }

        return output;
    }
}
