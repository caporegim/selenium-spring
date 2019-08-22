package tests;

import com.selenium.steps.IntentToFileStep;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class IntentToFileTest extends BaseModuleTest {
    @Autowired
    private IntentToFileStep intentToFileStep;

    @Test
    void testIntentToFile() {
        intentToFileStep.intentToFile();
        Assert.assertTrue("Should see intent to file success result", intentToFileStep.getIntentToFilePage().operationWasSuccessfull());
    }
}
