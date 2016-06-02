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

    public void handleOneWordCommand(CommandLineControllerInterface commandLineController) {
        if(Constants.EXIT.equals(console.getOneWordCommand())) {
            System.out.print("About to exit...");
            System.exit(0);
        }

        commandLineController.displayInCommandLine(promptBuilder.buildDefaultPrompt());
        System.out.print("[LOG]: {handleOneWordCommand}");
    }

    public void handleTwoWordCommand(CommandLineControllerInterface commandLineController) {
        commandLineController.displayInCommandLine(promptBuilder.buildDefaultPrompt());
        System.out.print("[LOG]: {handleTwoWordCommand}");
    }
}
