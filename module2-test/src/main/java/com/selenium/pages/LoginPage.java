package com.selenium.pages;

import com.selenium.framework.pages.BasePage;
import com.selenium.support.Credentials;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    private Credentials credentials;

    @FindBy(id = "warning-modal-ok-btn")
    private WebElement okButton;

    @FindBy(css = "div.panel-footer > a")
    private WebElement loginUsingPassword;

    @FindBy(id = "stationIdPopUp")
    private WebElement stationId;

    @FindBy(id = "usernamePopUp")
    private WebElement usernamePopUp;

    @FindBy(id = "passwordPopUp")
    private WebElement passwordPopUp;

    @FindBy(id = "profileIdPopUp")
    private WebElement profileIdPopUp;

    @FindBy(xpath = "//*[@title='Login']")
    private WebElement loginButton;

    @Override
    public String getPageUrlEnd() {
        return "";
    }

    @Autowired
    public LoginPage(WebDriver driver, Credentials credentials) {
        super(driver);
        this.credentials = credentials;
    }

    public void clickOnLoginUsingPassword() {
        sleepSeconds(1);
        okButton.sendKeys(Keys.SPACE);
        sleepSeconds(1);
        clickOn(loginUsingPassword);
        stationId.clear();
        stationId.sendKeys(credentials.getAppStationId());
        usernamePopUp.clear();
        usernamePopUp.sendKeys(credentials.getAppUsername());
        passwordPopUp.clear();
        passwordPopUp.sendKeys(credentials.getAppPassword());
        profileIdPopUp.clear();
        profileIdPopUp.sendKeys(credentials.getAppRole());
        sleepSeconds(1);
        loginButton.sendKeys(Keys.ENTER);
    }


}
