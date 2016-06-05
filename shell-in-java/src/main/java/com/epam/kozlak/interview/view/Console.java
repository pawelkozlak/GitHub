package com.epam.kozlak.interview.view;


import com.epam.kozlak.interview.util.Constants;

public class Console {
    private static Console ourInstance = new Console();

    private String oneWordCommand;
    private String[] twoWordCOmmand;
    private String[] moreThanTwoWordCommand;
    private String currentCommandPrompt;
    private String currentTreeContent;

    private Console() {
    }

    public static Console getInstance() {
        return ourInstance;
    }

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

    public String[] getMoreThanTwoWordCommand() {
        return moreThanTwoWordCommand;
    }

    public void setMoreThanTwoWordCommand(String[] moreThanTwoWordCommand) {
        this.moreThanTwoWordCommand = moreThanTwoWordCommand;
    }

    public String getCurrentCommandPrompt() {
        return currentCommandPrompt;
    }

    public void setCurrentCommandPrompt(String currentCommandPrompt) {
        this.currentCommandPrompt = currentCommandPrompt;
    }
    
}
