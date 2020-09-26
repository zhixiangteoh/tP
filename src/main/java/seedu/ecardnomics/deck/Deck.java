package seedu.ecardnomics.deck;

import java.util.ArrayList;

public class Deck {
    private String name;
    private ArrayList<FlashCard> deck;

    public Deck(String name) {
        this.name = name;
        deck = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(FlashCard flashCard) {
        deck.add(flashCard);
    }

    @Override
    public String toString() {
        String output = name + ":";
        for (int i = 0; i < deck.size(); i++) {
            output += "\n" + i + ". " + deck.get(i).toString() + "\n";
        }

        return output;
    }
}
