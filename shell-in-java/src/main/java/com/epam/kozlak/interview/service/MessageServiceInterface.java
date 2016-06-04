package com.epam.kozlak.interview.service;


public interface MessageServiceInterface {

    public void handleOneWordCommand(CommandLineControllerInterface commandLineController );
    public void handleTwoWordCommand(CommandLineControllerInterface commandLineController);
    public void handleMoreThanTwoWordCommand(CommandLineControllerInterface commandLineController);
}
