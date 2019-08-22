package com.selenium.support;

import com.selenium.framework.support.DriverConfiguration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("file:${user.dir}/module.properties")
public class Module2SpecificConfiguration {
    @Value("${proxyUsername}")
    private String proxyUsername;

    @Value("${proxyPassword}")
    private String proxyPassword;

    private final ChromeBasicAuthHelper chromeBasicAuthHelper = new ChromeBasicAuthHelper();

    @Bean
    public ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        if (chromeBasicAuthHelper.getExtensionFile() != null) {
            options.addExtensions(chromeBasicAuthHelper.getExtensionFile());
        }
        return options;
    }

    @Bean
    @Primary
    public DriverConfiguration createDriverConfiguration() {
        return webDriver -> {
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
            ChromeBasicAuthHelper.configureAuth(webDriver, proxyUsername, proxyPassword);
        };
    }

}
