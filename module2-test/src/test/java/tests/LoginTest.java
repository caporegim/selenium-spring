package tests;

import com.selenium.pages.WorkQueuePage;
import com.selenium.steps.LoginStep;
import com.selenium.support.Module2SpecificConfiguration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {Module2SpecificConfiguration.class})
public class LoginTest extends BaseTest {

    @Autowired
    private LoginStep loginStep;

    @Autowired
    private WorkQueuePage workQueuePage;

    @Test
    void testLogin() {
        loginStep.clickOnLoginWithPassword();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(workQueuePage.isLoaded());
    }
}
