package com.selenium.framework.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class DriverManager {

    @Value("${browser:chrome}")
    private String browser;

    @Value("${selenium-grid-url}")
    private String remoteURL;

    @Bean
    public WebDriver createWebDriver() {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "ie":
                driver = createIEDriver();
                break;
            case "firefox":
                driver = createFirefoxDriver();
                break;
            default:
                driver = createRemoteWebDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().version("75").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("disable-extensions");
        options.addArguments("--disable-infobars");
        options.setExperimentalOption("useAutomationExtension", false);

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        return new ChromeDriver(options);
    }

    private WebDriver createIEDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        return new InternetExplorerDriver(options);
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    private WebDriver createRemoteWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        try {
            return new RemoteWebDriver(new URL(remoteURL),
                                       capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
