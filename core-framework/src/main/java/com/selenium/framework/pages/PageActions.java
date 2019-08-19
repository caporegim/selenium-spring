package com.selenium.framework.pages;

import org.openqa.selenium.WebElement;

public abstract class PageActions {

    public void clickOn(WebElement element) {
        element.click();
    }

    public void typeInto(WebElement element, String string) {
        element.sendKeys(string);
    }
}
