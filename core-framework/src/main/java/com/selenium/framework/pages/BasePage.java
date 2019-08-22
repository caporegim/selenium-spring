package com.selenium.framework.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.Arrays;
import java.util.Optional;

public abstract class BasePage extends PageActions {

    protected WebDriver driver;

    protected FluentWait<WebDriver> wait;

    @Autowired
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoreAll(Arrays.asList(NoSuchElementException.class, ElementNotInteractableException.class, ElementNotVisibleException.class, ElementNotSelectableException.class));
    }

    public WebElement waitClickableWebElement(WebElement webElement) {
        System.out.println(webElement);
        final WebElement result = wait.until((webDriver) -> ExpectedConditions.elementToBeClickable(webElement)).apply(driver);
        return Optional.ofNullable(result).orElseThrow(() -> new RuntimeException("Clickable element returned null."));
    }

    public void sleepSeconds(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract String getPageUrl();

}
