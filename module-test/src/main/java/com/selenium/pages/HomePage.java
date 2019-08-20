package com.selenium.pages;

import com.selenium.framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    @FindBy(css = "li[class*='tab-flight-status']")
    private WebElement lnkFlightStatus;

    @Autowired
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void openFlightStatus() {
        clickOn(lnkFlightStatus);
    }
}
