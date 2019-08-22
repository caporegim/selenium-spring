package com.selenium.framework.support;


import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScreenShotMaker {
    @Autowired
    private final WebDriver webDriver;

    @Value("screenshot.folder:file:${user.dir}")
    private String pathToScreenshotFolder;

    public ScreenShotMaker(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void makeScreenShot(String description) {
        final TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        final File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        if(pathToScreenshotFolder == null) {
            pathToScreenshotFolder = "/Users/petr.metin/";
        }
        final String filePath = pathToScreenshotFolder + "_"+description+ "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:ss")) + ".jpg";
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(screenshotFile, destFile);
            System.out.println("Screen shot made at " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
