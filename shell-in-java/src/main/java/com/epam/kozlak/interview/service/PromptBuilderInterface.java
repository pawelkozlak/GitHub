package com.epam.kozlak.interview.service;

public interface PromptBuilderInterface {

    public String buildCurentDirPrompt();
    public String buildDefaultPrompt();
    public String buildUserParameterPrompt(String userParameter);
    public String buildDir();
    public String buildTree();

}
