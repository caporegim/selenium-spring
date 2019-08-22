package com.selenium.pages;

import com.selenium.framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class VeteranProfilePage extends BasePage {

    @FindBy(id = "vetHeaderLName")
    private WebElement veteranNameElement;


    protected VeteranProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return veteranNameElement.isDisplayed();
    }

    @Override
    public String getPageUrlEnd() {
        return "veteranProfile";
    }


}
