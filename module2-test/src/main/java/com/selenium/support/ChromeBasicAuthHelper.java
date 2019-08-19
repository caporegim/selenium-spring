package com.selenium.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Helper to pass http proxy screen in chrome.
 * Solution based on https://stackoverflow.com/questions/44940815/how-to-set-proxy-authentication-in-seleniumwebdriver-for-chrome-browser/44950452#44950452
 *
 * @author petr.metin
 */
public class ChromeBasicAuthHelper {
    private static final String REGEX_FOR_URLS_BEHIND_PROXY = "va.gov";
    private static final String EXTENSION_SETTINGS_PAGE = "chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/options.html";

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private File extensionFile;

    public ChromeBasicAuthHelper() {
        final URL resource = getClass().getClassLoader().getResource("chrome/MultiPass-for-HTTP-basic-authentication_v0.8.4.crx");
        try {
            //add URLDecoder.decode() to solve issues when path contains spaces
            final String filePath = resource != null ? URLDecoder.decode(resource.getFile(), "UTF-8") : null;
            System.out.println("Using basic auth extension from : " + filePath);
            extensionFile = filePath != null ? new File(URLDecoder.decode(filePath, "UTF-8")) : null;
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error during reading extension from path :" + resource.getFile());
        }
    }

    /**
     * Setup url and credentials in extension.
     */
    public static void configureAuth(WebDriver driver, String proxyUser, String proxyPassword) {
        System.out.println("configuring auth...");
        driver.get(EXTENSION_SETTINGS_PAGE);
        driver.findElement(By.id("url")).sendKeys(REGEX_FOR_URLS_BEHIND_PROXY);
        driver.findElement(By.id("username")).sendKeys(proxyUser);
        driver.findElement(By.id("password")).sendKeys(proxyPassword);
        driver.findElement(By.className("credential-form-submit")).click();
    }

    public File getExtensionFile() {
        return this.extensionFile;
    }
}
