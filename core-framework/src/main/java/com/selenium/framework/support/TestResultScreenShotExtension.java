package com.selenium.framework.support;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import tests.BaseTest;

import java.lang.reflect.Method;

public class TestResultScreenShotExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println(context);
        context.getTestInstance().ifPresent((test) -> {
            BaseTest baseTest = (BaseTest) test;
            new ScreenShotMaker(baseTest.getDriver()).makeScreenShot(context.getTestMethod().map(Method::getName).orElse("default-test-description"));
        });
    }
}
