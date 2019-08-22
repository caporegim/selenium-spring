package tests;

import com.selenium.steps.IntentToFileStep;
import com.selenium.support.Module2SpecificConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {Module2SpecificConfiguration.class})
public class IntentToFileTest extends BaseTest {
    @Autowired
    private IntentToFileStep intentToFileStep;

    @Test
    void testIntentToFile() {
        intentToFileStep.intentToFile();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
