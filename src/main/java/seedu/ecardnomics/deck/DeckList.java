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
        assert !deckList.contains(deck.getName()) : "The deck list has duplicate decks.";
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
     * Checks whether a deck with the same deck name is already in the deck.
     * @param deck
     * @return boolean
     */
    public boolean contains(Deck deck) {
        for (Deck thisDeck : deckList) {
            if (thisDeck.getName().equals(deck.getName())) {
                return true;
            }
        }
        return false;
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
     * Returns the ArrayList of all decks available in the deck list.
     *
     * @return an ArrayList
     */
    public ArrayList<Deck> getAllDecks() {
        return deckList;
    }

    /**
     * Returns the names of all decks in the deck list in ArrayList.
     *
     * @return ArrayList
     */
    public ArrayList<String> getAllNames() {
        ArrayList<String> deckNameOfDecks = new ArrayList<>();
        for (Deck deck: deckList) {
            deckNameOfDecks.add(deck.getName());
        }

        return deckNameOfDecks;
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

    /**
     * Returns a string including index and name, tag of all the deck available.
     *
     * @return A String representing index, name and tag
     */
    @Override
    public String toString() {
        String output = "";
        String offset = "   ";
        for (int i = 0; i < deckList.size(); i++) {
            if (offset.length() <= (i / 10 + 2)) {
                offset += " ";
            }
            output += (i + 1) + ". " + deckList.get(i).getName();
            if (deckList.get(i).getTag().size() !=  0) {
                output += "\n";
                output += offset + "Tags: " + deckList.get(i).getTagString();
            }
            if (i != deckList.size() - 1) {
                output += "\n";
            }
        }

        return output;
    }
}
