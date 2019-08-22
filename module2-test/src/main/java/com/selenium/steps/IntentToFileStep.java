package com.selenium.steps;

import com.selenium.pages.IntentToFilePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntentToFileStep {
    @Autowired
    private IntentToFilePage intentToFilePage;

    @Autowired
    private SearchVeteranStep searchVeteranStep;

    public void intentToFile() {
        searchVeteranStep.gotToIntentToFile();
        intentToFilePage.createNewIntentToFile();
    }

}
