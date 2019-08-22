package com.selenium.pages;

import com.selenium.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class WorkQueuePage extends BasePage {

    @FindBy(id = "toggleSearchBarButton")
    private WebElement searchDropDown;

    @FindBy(id = "search-field")
    private WebElement searchField;

    @FindBy(id = "vetProfileButton")
    private WebElement openProfileButton;

    @FindBy(id = "intent_to_file")
    private WebElement intentToFileLink;

    @FindBy(css = "html head title")
    private WebElement pageTitle;


    protected WorkQueuePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrlEnd() {
        return "workQueueInbox";
    }

    public WorkQueuePage searchVeteran() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("toggleSearchBarButton")));
            searchDropDown.click();
        } catch (NoSuchElementException | TimeoutException e) {
        }
        searchDropDown.click();
        searchField.clear();
        searchField.sendKeys("792647811", Keys.ENTER);
        //searchField.sendKeys("792647811");//todo review that is wrong with this line
        //openProfileButton.submit();
        return this;
    }

    public void gotToIntentToFile() {
        intentToFileLink.click();
    }

    public boolean isPageContentLoaded() {
        return pageTitle.getText().contains("Work Queue");
    }


}
