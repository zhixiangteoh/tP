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
            output += "\n" + (i + 1) + ". " + deck.get(i).toString() + "\n";
        }
        return output;
    }

    public String toString(String type) {
        String output = "";
        for (int i = 0; i < deck.size(); i++) {
            output += (i + 1) + ". " + deck.get(i).toString(type) + "\n" + System.lineSeparator();
        }
        return output;
    }
}
