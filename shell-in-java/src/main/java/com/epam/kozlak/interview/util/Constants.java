package com.epam.kozlak.interview.util;

public final class Constants {

    private Constants() {}  // this class should not be instantiate

    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String COMMAND_CWD = "$cwd";
    public static final String COMMAND_RESET = "reset";
    public static final String COMMAND_PROMPT = "prompt";
    public static final String COMMAND_DIR = "dir";
    public static final String COMMAND_TREE = "tree";
    public static final String COMMAND_CD = "cd";


    public static final String DOLLAR = "$";
    public static final String MYSHELL = "[MyShell]";
    public static final String RIGHT_BRACKET =">";
    public static final String SEMICOLON =":";
    public static final String UNKNOWN_COMMAND ="unknown command";
    public static final String PARENT_DIR ="..";
    public static final String EXIT ="exit";
    public static final String TO_MANY_ARGUMENTS ="To many arguments..";

    public static final String DEFAULT_PROMPT = Constants.MYSHELL + Constants.DOLLAR + Constants.RIGHT_BRACKET;

}
