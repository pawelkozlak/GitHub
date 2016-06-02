package com.epam.kozlak.interview.main;

import com.epam.kozlak.interview.processor.ShellInJavaProcessorImpl;
import com.epam.kozlak.interview.processor.ShellInJavaProcessorInterface;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        try {
            ShellInJavaProcessorInterface shellInJavaProcessorInterface = new ShellInJavaProcessorImpl();
            shellInJavaProcessorInterface.process();
        } catch (IOException e) {
            System.out.println("Error has occured.");
            e.printStackTrace();
        }
    }
}
