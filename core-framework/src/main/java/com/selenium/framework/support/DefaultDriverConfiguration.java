package com.selenium.framework.support;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DefaultDriverConfiguration implements DriverConfiguration {
    @Override
    public void configure(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
