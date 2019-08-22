package com.selenium.pages;

import com.selenium.framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class IntentToFilePage extends BasePage {

    @FindBy(id = "createNewIntentToFileTemplateButton")
    private WebElement intentToFileButton;

    @FindBy(id = "receivedDate")
    private WebElement receivedDateInput;


    @FindBy(id = "saveNewIntentToFileTemplateButton")
    private WebElement saveButton;


    protected IntentToFilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "intentToFile";
    }

    public void createNewIntentToFile() {
        intentToFileButton.click();
        receivedDateInput.sendKeys("08/01/2019");
        saveButton.click();
    }


}
