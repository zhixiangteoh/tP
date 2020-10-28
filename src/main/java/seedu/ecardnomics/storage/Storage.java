package seedu.ecardnomics.storage;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.deck.FlashCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public static final String FILE_PATH = "./data/deckList.txt";
    public static final String FOLDER_PATH = "./data";

    public DeckList load(DeckList deckList) {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File(FILE_PATH);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return deckList;
        }

        String line;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            int deckIndex = Integer.parseInt(line.substring(7));
            line = scanner.nextLine();
            String deckName = line.substring(7);
            Deck deck = new Deck(deckName);
            line = scanner.nextLine();
            line = line.substring(line.indexOf("|") + 2);
            String[] tags = line.split(" | ");
            deck.addTag(tags);
            line = scanner.nextLine();
            int deckSize = Integer.parseInt(line.substring(7));

            for (int i = 0; i < deckSize; i++) {
                line = scanner.nextLine();
                String question = line.substring(4);
                line = scanner.nextLine();
                String answer = line.substring(4);
                FlashCard flashCard = new FlashCard(question, answer);
                deck.add(flashCard);
            }
            deckList.addDeck(deck);
            scanner.nextLine();
        }
        return deckList;
    }

    public void write(DeckList deckList) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);

        for (int i = 0; i < deckList.size(); i++) {
            Deck deck = deckList.getDeck(i);
            fw.write("deck | " + i);
            fw.write(System.lineSeparator());
            fw.write("name | " + deck.getName());
            fw.write(System.lineSeparator());
            fw.write("tags | " + deck.getTagString());
            fw.write(System.lineSeparator());
            fw.write("size | " + deck.size());
            fw.write(System.lineSeparator());
            for (int j = 0; j < deck.size(); j++) {
                fw.write("Q | " + deck.get(j).getQuestion());
                fw.write(System.lineSeparator());
                fw.write("A | " + deck.get(j).getAnswer());
                fw.write(System.lineSeparator());
            }
            fw.write("================================================================================");
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
}
