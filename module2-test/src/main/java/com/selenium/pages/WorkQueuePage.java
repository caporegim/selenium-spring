package com.selenium.pages;

import com.selenium.framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class WorkQueuePage extends BasePage {
    protected WorkQueuePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "workQueueInbox";
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains(getPageUrl());
    }
}
