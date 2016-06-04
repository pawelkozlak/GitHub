package com.epam.kozlak.interview.service;

import com.epam.kozlak.interview.util.Constants;


public class PromptBuilderImpl implements PromptBuilderInterface {

    @Override
    public String buildCurentDirPrompt() {
        return Constants.MYSHELL + Constants.SPACE + System.getProperty("user.dir") + Constants.RIGHT_BRACKET;
    }
    @Override
    public String buildDefaultPrompt() {
        return Constants.DEFAULT_PROMPT;
    }
    @Override
    public String buildUserParameterPrompt(String userParameter) {
        return Constants.MYSHELL + Constants.SPACE + userParameter + Constants.RIGHT_BRACKET;
    }
    @Override
    public String buildDir() {
        return "[LOG]: DIR STRUCTURE - TODO " + Constants.NEW_LINE;
    }
    @Override
    public String buildTree() {
        return "[LOG]: TREE STRUCTURE - TODO "  + Constants.NEW_LINE;
    }

    @Override
    public String buildUnknownCommand(String command) {
        return Constants.UNKNOWN_COMMAND + ": "+ command  + Constants.NEW_LINE;
    }

    @Override
    public String buildUnknownCommand(String[] command) {
        String returnValue;
        switch(command[0]){
            case Constants.COMMAND_PROMPT:
                returnValue = "Not valid parameters for command: " + Constants.COMMAND_PROMPT + Constants.NEW_LINE;
                break;
            case Constants.COMMAND_DIR:
                returnValue = "DIR command should be executed with no parameters" + Constants.NEW_LINE;
                break;
            case Constants.COMMAND_TREE:
                returnValue = "TREE command should be executed with no parameters" + Constants.NEW_LINE;
                break;
            case Constants.COMMAND_RESET:
                returnValue = "RESET command should be executed with no parameters" + Constants.NEW_LINE;
                break;
            default:
                returnValue=Constants.UNKNOWN_COMMAND + ": "+ command[0] + Constants.NEW_LINE;
        }
        return returnValue;
    }
}
