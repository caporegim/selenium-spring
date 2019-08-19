package com.selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public abstract class PageActions {

    public void clickOn(WebElement element) {
        element.click();
    }

    public void waitAndClickOn(WebElement element) {

        waitClickableWebElement(element).click();
    }

    protected abstract WebElement waitClickableWebElement(WebElement element);

    public void typeInto(WebElement element, String string) {
        element.sendKeys(string);
    }


    public void sendKey(WebElement webElement, Keys keys){
        webElement.sendKeys(keys);
    }

}
