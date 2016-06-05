package com.epam.kozlak.interview.service;

import java.io.File;

import com.epam.kozlak.interview.util.Constants;


public class PromptBuilderImpl implements PromptBuilderInterface {

	String pause = "-";
	String currentTreeContent = "";
	
	@Override
    public String buildCurentDirPrompt() {
        return Constants.MYSHELL + Constants.SPACE + System.getProperty("user.dir") + Constants.RIGHT_BRACKET;
    }
    @Override
    public String buildDefaultPrompt() {
        return Constants.DEFAULT_PROMPT;
    }
    @Override
    public String buildUserParameterPrompt(String userParameter) {
        return Constants.MYSHELL + Constants.SPACE + userParameter + Constants.RIGHT_BRACKET;
    }
    @Override
    public String buildDir() {
    	String currentDirContent ="";
		File f = new File(System.getProperty("user.dir"));
    	File[] files = f.listFiles();
		for (File file : files) {
		if (file.isDirectory()){
			currentDirContent += "DIR " + file.getName() + Constants.NEW_LINE;	
		}
		else {
			currentDirContent += "FILE " + file.getName() + Constants.NEW_LINE;
			}
		}
		return currentDirContent;
    }
   
    @Override
    public String buildTree(String path) {
    	File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return "no such file or directory";

          for (File f : list) {  
			if ( f.isDirectory() ) {     		
				currentTreeContent +=  pause + f.getName() + Constants.NEW_LINE;
				pause += "-"; 							
				buildTree( f.getAbsolutePath() );					
			}
            else {
            	currentTreeContent +=  pause + f.getName() + Constants.NEW_LINE ;			
				}
		  }
		 pause = pause.substring(0, pause.length() - 1);
    	return currentTreeContent;
    }    

    @Override
    public String setTreeContent(){
    	currentTreeContent = "";
    	pause = "-";
    	return "";
    }
    @Override
    public String buildUnknownCommand(String command) {
        return Constants.UNKNOWN_COMMAND + ": "+ command  + Constants.NEW_LINE;
    }

    @Override
    public String buildUnknownCommand(String[] command) {
        String returnValue;
        switch(command[0]){
            case Constants.COMMAND_PROMPT:
                returnValue = "Not valid parameters for command: " + Constants.COMMAND_PROMPT + Constants.NEW_LINE;
                break;
            case Constants.COMMAND_DIR:
                returnValue = "DIR command should be executed with no parameters" + Constants.NEW_LINE;
                break;
            case Constants.COMMAND_TREE:
                returnValue = "TREE command should be executed with no parameters" + Constants.NEW_LINE;
                break;
            case Constants.COMMAND_RESET:
                returnValue = "RESET command should be executed with no parameters" + Constants.NEW_LINE;
                break;
            default:
                returnValue=Constants.UNKNOWN_COMMAND + ": "+ command[0] + Constants.NEW_LINE;
        }
        return returnValue;
    }
}
