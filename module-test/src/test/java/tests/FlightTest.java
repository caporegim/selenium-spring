package tests;

import com.selenium.steps.FlightStatusSteps;
import com.selenium.steps.HomeSteps;
import com.selenium.support.ModuleSpecificConfiguration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ModuleSpecificConfiguration.class})
class FlightTest extends BaseTest {

    @Autowired
    HomeSteps homeSteps;

    @Autowired
    FlightStatusSteps flightStatusSteps;

    @Test
    @Tag("smoke")
    void smokeTest() {
        homeSteps
                .openFlightStatus();
        flightStatusSteps
                .checkFlightByNumber("203");
    }

    @Test
    void sampleTest() {
        homeSteps
                .openFlightStatus();
        flightStatusSteps
                .checkFlightByNumber("203");
    }
}
