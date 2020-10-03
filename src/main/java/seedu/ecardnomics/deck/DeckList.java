package seedu.ecardnomics.deck;

import java.util.ArrayList;

public class DeckList {
    private ArrayList<Deck> deckList;

    public DeckList() {
        deckList = new ArrayList<>();
    }

    public void addDeck(Deck deck) {
        deckList.add(deck);
    }

    /**
     * @return size of deck of
     */
    public int size(){
        return deckList.size();
    }

    /**
     * Returns a deck from deck list based on given index
     *
     * @param index Index of deck to be found
     * @return Deck found at <code>index</code>
     */
    public Deck getDeck(int index){
        return deckList.get(index);
    }


    /**
     * Returns index of deck in deck list
     *
     * @param deck Deck which index is to be found
     * @return Index found of <code>deck</code>
     */
    public int getIndexOf(Deck deck){
        return deckList.indexOf(deck);
    }

    @Override
    public String toString() {
        String output = "Decks:";
        for (int i = 0; i < deckList.size(); i++) {
            output += "\n" + i + ". " + deckList.get(i).getName();
        }

        return output;
    }
}
