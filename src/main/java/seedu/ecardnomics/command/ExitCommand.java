package seedu.ecardnomics.command;

public class ExitCommand extends Command{
    public ExitCommand(){
    }

    @Override
    public void execute(){
    }

    /** Returns if command given is an of instance of <code>EditCommand</code> */
    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
