package com.blazedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReservePage {
    public static final Target RESULTS_TITLE = Target.the("results page title")
            .located(By.cssSelector("div.container h3"));

    public static final Target FLIGHTS_TABLE = Target.the("flights table")
            .located(By.cssSelector("table.table"));

    public static final Target FLIGHT_ROWS = Target.the("flight rows in table")
            .located(By.cssSelector("table.table tbody tr"));

    public static final Target FLIGHT_NUMBER_IN_ROW = Target.the("flight number in row")
            .located(By.cssSelector("td:nth-child(2)"));

    public static final Target AIRLINE_IN_ROW = Target.the("airline in row")
            .located(By.cssSelector("td:nth-child(3)"));

    public static final Target PRICE_IN_ROW = Target.the("price in row")
            .located(By.cssSelector("td:nth-child(6)"));

    

    public static Target rowContainingFlight(String flightNumber) {
        return Target.the("row containing flight " + flightNumber)
                .located(By.xpath("//input[@name='flight' and @value='" + flightNumber + "']/ancestor::tr"));
    }

    public static final Target FIRST_CHOOSE_BUTTON = Target.the("first flight choose button")
            .located(By.cssSelector("table.table tbody tr input[type='submit']"));

    public static Target chooseButtonForFlightNumber(String flightNumber) {
        return Target.the("choose button for flight " + flightNumber)
                .located(By.xpath("//table[contains(@class,'table')]//tr[td[2][normalize-space()='"
                        + flightNumber + "']]//input[@type='submit']"));
    }

    public static Target chooseButtonForAirline(String airline) {
        return Target.the("choose button for airline " + airline)
                .located(By.xpath("//table[contains(@class,'table')]//tr[td[3][normalize-space()='"
                        + airline + "']]//input[@type='submit']"));
    }
}
