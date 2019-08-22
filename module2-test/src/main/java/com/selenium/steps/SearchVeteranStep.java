package com.selenium.steps;

import com.selenium.pages.LoginPage;
import com.selenium.pages.WorkQueuePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchVeteranStep {
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private WorkQueuePage workQueuePage;

    public SearchVeteranStep searchVeteran(){
        loginPage.clickOnLoginUsingPassword();
        loginPage.sleepSeconds(2);
        workQueuePage.searchVeteran();
        return this;
    }

    public void gotToIntentToFile(){
        searchVeteran().gotToIntentToFile();
    }
}
