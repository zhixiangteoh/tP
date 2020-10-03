package seedu.ecardnomics;

public enum Mode {
    NORMAL("Normal"), DECK("Deck");

    private String name;

    private Mode(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

}
