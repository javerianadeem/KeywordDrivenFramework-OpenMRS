package com.qa.mrs.keyword.tests;


import com.qa.mrs.keyword.engine.KeywordEngine;
import org.testng.annotations.Test;

public class Tests {

    public KeywordEngine keywordEngine;

    public Tests() {
        keywordEngine = new KeywordEngine();
    }

    @Test
    public void loginTest() {
        keywordEngine.startExecution("login");
    }

    @Test
    public void loginValidationTest() {
        keywordEngine.startExecution("loginValidation");
    }
}
