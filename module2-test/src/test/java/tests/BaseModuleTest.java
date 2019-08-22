package tests;

import com.selenium.support.Module2SpecificConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {Module2SpecificConfiguration.class})
public abstract class BaseModuleTest extends BaseTest {
}
