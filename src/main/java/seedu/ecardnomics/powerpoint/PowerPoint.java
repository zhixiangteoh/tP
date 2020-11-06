package seedu.ecardnomics.powerpoint;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import seedu.ecardnomics.Ui;
import seedu.ecardnomics.deck.Deck;
import seedu.ecardnomics.deck.FlashCard;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PowerPoint {
    private Deck deck;
    private XMLSlideShow pptx = new XMLSlideShow();
    private XSLFSlideMaster defaultMaster = pptx.getSlideMasters().get(0);
    private Color bgColor;
    private Color textColor;

    public static final int[][][] COLOR_SCHEMES = {
            {{26,81,144}, {162, 162, 161}}, // Turkish Sea and Silver
            {{161, 57, 66}, {189, 128, 56}}, // Gold and Scarlet
            {{255, 231, 122}}, {{44, 95, 45}}, // Yellow and Green
            {{4, 30, 66}}, {{175, 234, 220}}, // Sailor Blue and Mint
            {{16, 24, 32}}, {{242, 170, 76}}, // Black and Orange
            {{255, 214, 98}}, {{0, 83, 156}}, // Aspen Gold and Princess Blue
            {{28, 28, 27}}, {{206, 74, 126}}, // Nebulosity and Pink Yarrow
            {{110, 110, 109}}, {{250, 208, 201}}, // Charcoal Gray and Pink Salt
            {{173, 223, 173}}, {{44, 95, 45}}, // Moss Green and Forest Green
            {{250, 235, 239}},{{46, 62, 128}} // Pink and Navy
    };

    public static final String PPTX_DIR = "pptx/";
    public static final String PPTX_EXT = ".pptx";


    public PowerPoint(Deck deck) {
        this.deck = deck;
        bgColor = Color.white;
        textColor = Color.black;
    }

    public PowerPoint(Deck deck, Color bgColor, Color textColor) {
        this.deck = deck;
        this.bgColor = bgColor;
        this.textColor = textColor;
    }


    private void newIntroSlide() {
        XSLFSlideLayout layout = defaultMaster.getLayout(SlideLayout.TITLE);
        XSLFSlide slide = pptx.createSlide(layout);

        slide.getBackground().setFillColor(bgColor);

        XSLFTextShape title = slide.getPlaceholder(0);
        XSLFTextShape subtitle = slide.getPlaceholder(1);
        slide.removeShape(subtitle);

        title.clearText();

        XSLFTextParagraph p = title.addNewTextParagraph();
        XSLFTextRun r = p.addNewTextRun();

        r.setText(deck.getName());
        r.setFontColor(textColor);
        r.setFontSize(60.);
    }

    private void newSlide(String titleText, String text) {
        XSLFSlideLayout layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide slide = pptx.createSlide(layout);

        XSLFTextShape title = slide.getPlaceholder(0);
        XSLFTextShape object = slide.getPlaceholder(1);

        title.clearText();
        object.clearText();

        XSLFTextParagraph p = title.addNewTextParagraph();
        XSLFTextRun r = p.addNewTextRun();

        r.setText(titleText);
        r.setFontColor(textColor);
        r.setFontSize(50.);

        p = object.addNewTextParagraph();
        r = p.addNewTextRun();

        r.setText(text);
        r.setFontColor(textColor);
        r.setFontSize(40.);
    }

    private void createPowerPoint() {
        newIntroSlide();

        for (int i = 0; i < deck.size(); ++i) {
            FlashCard card = deck.get(i);
            newSlide(Ui.QUESTION + (i + 1), card.getQuestion());
            newSlide(Ui.ANSWER, card.getAnswer());
        }
    }

    private void exportPowerPoint() {
        String fileName = PPTX_DIR + deck.getName() + PPTX_EXT;

        File folder = new File(PPTX_DIR);
        if (!folder.exists()) {
            folder.mkdir();
        }

        assert (folder.exists());

        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception e) {
            Ui.printMessage(Ui.CREATE_NEW_FILE_ERROR_LINE + fileName);
        }

        assert (file.exists());

        try {
            FileOutputStream out = new FileOutputStream(fileName);
            try {
                pptx.write(out);
                out.close();
                pptx.close();
                Ui.printDeckPptxLine(deck.getName());
            } catch (IOException e) {
                Ui.printMessage(Ui.WRITE_TO_FILE_ERROR_LINE);
            }
        } catch (FileNotFoundException e) {
            Ui.printMessage(fileName + Ui.FILE_NOT_FOUND_ERROR_LINE);
        }
    }

    /**
     * Creates a new PowerPoint Slide based on the current deck
     * and saves it as pptx/deckName.pptx
     */
    public void createNewPowerPoint() {
        createPowerPoint();
        exportPowerPoint();
    }
}
