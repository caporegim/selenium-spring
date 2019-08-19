package com.selenium.steps;

import com.selenium.pages.FlightStatusPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightStatusSteps {

    @Autowired
    private FlightStatusPage flightStatusPage;

    public void checkFlightByNumber(String flightNumber) {
        flightStatusPage
                .selectFlightNumber()
                .setFlightNumber(flightNumber)
                .checkFlightStatus();
    }
}
