package com.epam.kozlak.interview.service;


import com.epam.kozlak.interview.util.Constants;
import com.epam.kozlak.interview.view.Console;

public class MessageServiceImpl implements MessageServiceInterface {

    PromptBuilderInterface promptBuilder;
    Console console;

    public MessageServiceImpl () {
          promptBuilder = new PromptBuilderImpl();
          console = Console.getInstance();
    }

    @Override
    public void handleOneWordCommand(CommandLineControllerInterface commandLineController) {

        if(Constants.EXIT.equals(console.getOneWordCommand())) {
            commandLineController.displayInCommandLine("About to exit...");
            System.exit(0);
        }
        if(Constants.COMMAND_DIR.equals(console.getOneWordCommand())) {
            commandLineController.displayInCommandLine(promptBuilder.buildDir());
            commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
            return;
        }
        if(Constants.COMMAND_TREE.equals(console.getOneWordCommand())) {
            commandLineController.displayInCommandLine(promptBuilder.buildTree());
            commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
            return;
        }

        commandLineController.displayInCommandLine(promptBuilder.buildUnknownCommand(console.getOneWordCommand()));
        commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
    }

    @Override
    public void handleTwoWordCommand(CommandLineControllerInterface commandLineController) {

        String firstWord = console.getTwoWordCOmmand()[0];
        String secondWord = console.getTwoWordCOmmand()[1];

        switch (firstWord) {
            case Constants.COMMAND_PROMPT:
                if(Constants.COMMAND_CWD.equals(secondWord)){
                    console.setCurrentCommandPrompt(promptBuilder.buildCurentDirPrompt());
                    commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
                }
                else if (Constants.COMMAND_RESET.equals(secondWord)){
                    console.setCurrentCommandPrompt(promptBuilder.buildDefaultPrompt());
                    commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
                }
                else {
                    console.setCurrentCommandPrompt(promptBuilder.buildUserParameterPrompt(secondWord));
                    commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
                }
                break;
            case Constants.COMMAND_CD:
                    commandLineController.changeDirectory(secondWord);
                    console.setCurrentCommandPrompt(promptBuilder.buildCurentDirPrompt());
                    commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
                break;
            default:
                commandLineController.displayInCommandLine(promptBuilder.buildUnknownCommand(console.getTwoWordCOmmand()));
                commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());
                break;
        }
    }

    @Override
    public void handleMoreThanTwoWordCommand(CommandLineControllerInterface commandLineController) {
        commandLineController.displayInCommandLine(promptBuilder.buildUnknownCommand(console.getMoreThanTwoWordCommand()));
        commandLineController.displayInCommandLine(console.getCurrentCommandPrompt());

    }
}
