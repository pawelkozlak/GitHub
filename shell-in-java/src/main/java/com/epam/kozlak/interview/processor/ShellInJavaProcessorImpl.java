package com.epam.kozlak.interview.processor;


import com.epam.kozlak.interview.service.*;
import com.epam.kozlak.interview.util.Constants;

import java.io.IOException;

public class ShellInJavaProcessorImpl implements ShellInJavaProcessorInterface {

    CommandLineControllerInterface commandLineController;
    MessageServiceInterface messageService;
    int commandWordsNumber;

    public ShellInJavaProcessorImpl(){
        commandLineController = new CommandLineControllerImpl();
        messageService = new MessageServiceImpl();
        commandLineController.displayInCommandLine(Constants.DEFAULT_PROMPT);
    }

    public void process() throws IOException {
        while (true) {

            commandWordsNumber = commandLineController.readCommandFromCommandLine();
            if (commandWordsNumber >2) {
                commandLineController.displayInCommandLine(Constants.TO_MANY_ARGUMENTS);
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
