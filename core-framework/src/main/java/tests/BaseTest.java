package tests;

import com.selenium.framework.config.SpringConfig;
import com.selenium.framework.support.TestResultScreenShotExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, TestResultScreenShotExtension.class})
@ContextConfiguration(classes = {SpringConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {

    @Autowired
    private WebDriver driver;

    @Value("${base.url}")
    private String baseUrl;


    @BeforeEach
    public void beforeEach() {
        driver.get(baseUrl);
    }

    @AfterEach
    public void afterEach() {
        //driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
