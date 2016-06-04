package com.epam.kozlak.interview.service;


import com.epam.kozlak.interview.util.Constants;
import com.epam.kozlak.interview.view.Console;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CommandLineControllerImpl implements CommandLineControllerInterface {

    Scanner scanner;
    Console console;

    public CommandLineControllerImpl() {
        scanner = new Scanner(System.in);
        console = Console.getInstance();
    }

    public void displayInCommandLine(String msg) {
        System.out.print(msg);
    }


    public void changeDirectory(String dir) {
        if (Constants.PARENT_DIR.equals(dir)) {
            File file = new File(System.getProperty("user.dir"));
            String parentPath = file.getAbsoluteFile().getParent();
            System.setProperty("user.dir", parentPath);
        } else {

            File file = new File(dir);
            if (file.isDirectory()) {
                System.setProperty("user.dir", dir);
            } else {
                System.out.print("Directory does not exist." + Constants.NEW_LINE);
            }
        }
    }

    public int readCommandFromCommandLine() {
        String[] commandLine = scanner.nextLine().split(" ");
        if (0 == commandLine.length ) {
            // TODO
        }
        if (commandLine.length==1) {
            console.setOneWordCommand(commandLine[0]);
        }
        if (commandLine.length==2) {
            console.setTwoWordCOmmand(commandLine);
        }
        if (commandLine.length>2){
            console.setMoreThanTwoWordCommand(commandLine);
        }

        return commandLine.length;
    }


}
