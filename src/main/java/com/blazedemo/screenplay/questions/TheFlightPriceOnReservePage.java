package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ReservePage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class TheFlightPriceOnReservePage implements Question<String> {
    private final String flightNumber;

    private TheFlightPriceOnReservePage(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public static TheFlightPriceOnReservePage forFlight(String flightNumber) {
        return new TheFlightPriceOnReservePage(flightNumber);
    }

    @Override
    public String answeredBy(Actor actor) {
        ListOfWebElementFacades rows = ReservePage.FLIGHT_ROWS.resolveAllFor(actor);
        for (WebElementFacade row : rows) {
            String flightNum = row.findElement(By.cssSelector("td:nth-child(2)")).getText().trim();
            if (flightNum.equals(flightNumber)) {
                return row.findElement(By.cssSelector("td:nth-child(6)")).getText().trim();
            }
        }
        return "";
    }
}