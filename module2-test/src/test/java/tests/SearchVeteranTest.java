package tests;

import com.selenium.steps.SearchVeteranStep;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchVeteranTest extends BaseModuleTest {
    @Autowired
    private SearchVeteranStep searchVeteranStep;

    @Test
    void testSearchVeteran() {
        searchVeteranStep.searchVeteran();
        Assert.assertTrue("Should load WorkQueue page", searchVeteranStep.getWorkQueuePage().isCurrentUrlSameAsPageUrl());
    }
}
