package tests;

import com.selenium.pages.WorkQueuePage;
import com.selenium.steps.LoginStep;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginTest extends BaseModuleTest {

    @Autowired
    private LoginStep loginStep;

    @Autowired
    private WorkQueuePage workQueuePage;

    @Test
    void testLogin() {
        loginStep.clickOnLoginWithPassword();
        Assert.assertTrue("expect being redirected to Work Queue page", workQueuePage.isCurrentUrlSameAsPageUrl());
    }
}
