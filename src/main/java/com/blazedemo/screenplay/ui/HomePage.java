package com.blazedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target FROM_PORT = Target.the("origin city dropdown")
            .located(By.name("fromPort"));

    public static final Target TO_PORT = Target.the("destination city dropdown")
            .located(By.name("toPort"));

    public static final Target FIND_FLIGHTS_BUTTON = Target.the("find flights button")
            .located(By.cssSelector("input[type='submit'][value='Find Flights']"));
}