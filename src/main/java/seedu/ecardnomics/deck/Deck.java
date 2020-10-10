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

    public FlashCard get(int index) {
        return deck.get(index);
    }

    public void add(FlashCard flashCard) {
        deck.add(flashCard);
    }

    public int size() {
        return deck.size();
    }

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

    // public boolean equals(Deck other) {
    //     if (!name.equals(other.name)) {
    //         return false;
    //     }
    //     if (deck.size() != other.deck.size()) {
    //         return false;
    //     }
    //     for (int i = 0; i < deck.size(); i++) {
    //         if (!deck.get(i).equals(other.get(i))) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
