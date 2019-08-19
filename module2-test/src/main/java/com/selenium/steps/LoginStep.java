package com.selenium.steps;

import com.selenium.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginStep {

    @Autowired
    private LoginPage loginPage;

    public void clickOnLoginWithPassword() {
        loginPage.clickOnLoginUsingPassword();
    }
}
