package com.epam.kozlak.interview.service;


import java.io.IOException;

public interface CommandLineControllerInterface {

    public void displayInCommandLine (String msg);
    public void changeDirectory (String dir);
    public int readCommandFromCommandLine();

}
