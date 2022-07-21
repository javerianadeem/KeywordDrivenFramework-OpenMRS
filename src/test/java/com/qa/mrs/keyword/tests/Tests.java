package com.qa.mrs.keyword.tests;


import com.qa.mrs.keyword.engine.KeywordEngine;
import org.testng.annotations.Test;

public class Tests {

    public KeywordEngine keywordEngine;

    @Test
    public void loginTest(){
        keywordEngine = new KeywordEngine();
        keywordEngine.startExecution("login");
    }

    @Test
    public void loginValidationTest(){
        keywordEngine = new KeywordEngine();
        keywordEngine.startExecution("loginValidation");
    }
}
