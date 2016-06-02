package com.epam.kozlak.interview.service;

import com.epam.kozlak.interview.util.Constants;


public class PromptBuilderImpl implements PromptBuilderInterface {


    public String buildCurentDirPrompt() {
        return Constants.MYSHELL + System.getProperty("user.dir");

    }

    public String buildDefaultPrompt() {
        return Constants.DEFAULT_PROMPT;
    }

    public String buildUserParameterPrompt(String userParameter) {
        return Constants.MYSHELL + userParameter + Constants.RIGHT_BRACKET;
    }

    public String buildDir() {
        System.out.println("[LOG]: {buildDir}");
        return null;
    }

    public String buildTree() {
        System.out.println("[LOG]: {buildTree}");
        return null;
    }
}
