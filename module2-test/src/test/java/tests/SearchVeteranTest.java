package tests;

import com.selenium.steps.SearchVeteranStep;
import com.selenium.support.Module2SpecificConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {Module2SpecificConfiguration.class})
public class SearchVeteranTest extends BaseTest {
    @Autowired
    private SearchVeteranStep searchVeteranStep;

    @Test
    void testSearchVeteran() {
        searchVeteranStep.searchVeteran();
    }
}
