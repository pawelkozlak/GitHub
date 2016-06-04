package com.epam.kozlak.interview.processor;


import com.epam.kozlak.interview.service.*;
import com.epam.kozlak.interview.util.Constants;
import com.epam.kozlak.interview.view.Console;

import java.io.IOException;

public class ShellInJavaProcessorImpl implements ShellInJavaProcessorInterface {

    CommandLineControllerInterface commandLineController;
    MessageServiceInterface messageService;
    int commandWordsNumber;
    Console console;

    public ShellInJavaProcessorImpl(){
        console = Console.getInstance();
        commandLineController = new CommandLineControllerImpl();
        messageService = new MessageServiceImpl();
        console.setCurrentCommandPrompt(Constants.DEFAULT_PROMPT);
        commandLineController.displayInCommandLine(Constants.DEFAULT_PROMPT);


    }

    public void process() throws IOException {
        while (true) {

            commandWordsNumber = commandLineController.readCommandFromCommandLine();
            if (commandWordsNumber >2) {
                messageService.handleMoreThanTwoWordCommand(commandLineController);
            }
            if(commandWordsNumber ==0) {
                // do nothing
            }
            if(commandWordsNumber ==1){
                messageService.handleOneWordCommand(commandLineController);
            }
            if(commandWordsNumber ==2){
                messageService.handleTwoWordCommand(commandLineController);
            }
        }
    }
}
