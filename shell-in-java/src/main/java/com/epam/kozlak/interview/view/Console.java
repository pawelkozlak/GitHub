package com.epam.kozlak.interview.view;


public class Console {
    private static Console ourInstance = new Console();

    private String oneWordCommand;
    private String[] twoWordCOmmand;

    public String[] getTwoWordCOmmand() {
        return twoWordCOmmand;
    }

    public void setTwoWordCOmmand(String[] twoWordCOmmand) {
        this.twoWordCOmmand = twoWordCOmmand;
    }

    public String getOneWordCommand() {
        return oneWordCommand;
    }

    public void setOneWordCommand(String oneWordCommand) {
        this.oneWordCommand = oneWordCommand;
    }

    public static Console getInstance() {
        return ourInstance;
    }

    private Console() {
    }
}
