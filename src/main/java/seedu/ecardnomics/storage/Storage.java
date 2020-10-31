package seedu.ecardnomics.storage;

import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.DeckList;
import seedu.ecardnomics.deck.FlashCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    public static final String FILE_PATH = "./data/deckList.txt";
    public static final String FOLDER_PATH = "./data";
    public static final String DECK_INDEX_REGEX = "deck\\s\\|\\s\\d+";
    public static final String DECK_NAME_REGEX = "name\\s\\|\\s.+";
    public static final String TAGS_REGEX = "tags\\s\\|\\s.+";
    public static final String SIZE_REGEX = "size\\s\\|\\s\\d+";
    public static final String QUESTION_REGEX = "Q\\s\\|\\s.+";
    public static final String ANSWER_REGEX = "A\\s\\|\\s.+";

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
            if (line.matches(DECK_INDEX_REGEX)) {
                int deckIndex = Integer.parseInt(line.substring(7));
            } else {
                continue;
            }
            line = scanner.nextLine();
            String deckName = null;
            Deck deck = null;
            if (line.matches(DECK_NAME_REGEX)) {
                deckName = line.substring(7);
                deck = new Deck(deckName);
            } else {
                continue;
            }
            line = scanner.nextLine();
            if (line.matches(TAGS_REGEX)) {
                line = line.substring(line.indexOf("|") + 2);
                String[] tags = line.split(" | ");
                deck.addTag(tags);
            } else {
                continue;
            }
            line = scanner.nextLine();
            int deckSize = 0;
            if (line.matches(SIZE_REGEX)) {
                deckSize = Integer.parseInt(line.substring(7));
            } else {
                continue;
            }
            for (int i = 0; i < deckSize; i++) {
                line = scanner.nextLine();
                String question = null;
                if (line.matches(QUESTION_REGEX)) {
                    question = line.substring(4);
                } else {
                    continue;
                }
                line = scanner.nextLine();
                String answer = null;
                if (line.matches(ANSWER_REGEX)) {
                    answer = line.substring(4);
                } else {
                    continue;
                }
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
