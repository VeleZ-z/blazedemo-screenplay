package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ReservePage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;

public class TheAirlineOnReservePage implements Question<String> {
    private final String flightNumber;

    private TheAirlineOnReservePage(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public static TheAirlineOnReservePage forFlight(String flightNumber) {
        return new TheAirlineOnReservePage(flightNumber);
    }

    @Override
    public String answeredBy(Actor actor) {
        ListOfWebElementFacades rows = ReservePage.FLIGHT_ROWS.resolveAllFor(actor);
        for (WebElementFacade row : rows) {
            String flightNum = row.findElement(By.cssSelector("td:nth-child(2)")).getText().trim();
            if (flightNum.equals(flightNumber)) {
                return row.findElement(By.cssSelector("td:nth-child(3)")).getText().trim();
            }
        }
        return "";
    }
}