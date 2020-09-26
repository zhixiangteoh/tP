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

    @Override
    public String toString() {
        String output = "Decks:";
        for (int i = 0; i < deckList.size(); i++) {
            output += "\n" + i + ". " + deckList.get(i).getName();
        }

        return output;
    }
}
