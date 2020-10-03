package seedu.ecardnomics.command;

import seedu.ecardnomics.Ui;

public class VoidCommand extends Command{
    private String errorMessage;

    /** Constructor without <code>errorMessage</code> */
    public VoidCommand(){
        errorMessage = Ui.NOT_RECOGNISED_LINE;
    }

    /** Constructor with <code>errorMessage</code> */
    public VoidCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute(){
        Ui.printMessage(errorMessage);
    }
}
