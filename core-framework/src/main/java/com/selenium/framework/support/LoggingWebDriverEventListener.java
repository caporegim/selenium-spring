package com.selenium.framework.support;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class LoggingWebDriverEventListener extends AbstractWebDriverEventListener {
    private static final Logger log = LoggerFactory.getLogger(LoggingWebDriverEventListener.class);
    @Override
    public void beforeAlertAccept(WebDriver driver) {
        super.beforeAlertAccept(driver);

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        super.afterAlertAccept(driver);
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        super.afterAlertDismiss(driver);
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        super.beforeAlertDismiss(driver);
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        super.beforeNavigateBack(driver);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        super.afterNavigateBack(driver);
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        super.beforeNavigateForward(driver);
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        super.afterNavigateForward(driver);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        super.beforeNavigateRefresh(driver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        super.afterNavigateRefresh(driver);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("before findBy selector=[{}] element = [{}]", by, element );
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("after findBy selector=[{}] element = [{} , displayed={}]", by, element, Optional.ofNullable(element).map(e -> ""+e.isDisplayed()).orElse("IMPOSSIBLE") );
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("before clickOn element = [{}]", element );
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info("after clickOn element = [{}]", element );
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        log.info("before changeValue of element = [{}] to [{}]", element, keysToSend );
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        log.info("after changeValue of element = [{}] to [{}]", element, keysToSend );
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        log.info("before script script=[{}]", script );
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        log.info("after script script=[{}]", script );
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        super.afterSwitchToWindow(windowName, driver);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        log.info("Exception on URL=[{}] throwable=[{}]", driver.getCurrentUrl(), throwable.getMessage() );
        log.info("Page source contains createNewIntentToFileTemplateButton " + driver.getPageSource().contains("createNewIntentToFileTemplateButton"));
        try {
            final Path path = Paths.get("/users/petr.metin/selenium-debug/"+ StringUtils.substringAfterLast(driver.getCurrentUrl(), "/")+".html");
            System.out.println(path.toAbsolutePath());
            Files.write(path, driver.getPageSource().getBytes(), StandardOpenOption.CREATE_NEW);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        log.info("making screenshot..");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        log.info("screenshot has been made");
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
    }
}
