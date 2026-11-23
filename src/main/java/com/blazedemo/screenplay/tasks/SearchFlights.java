package com.blazedemo.screenplay.tasks;

import com.blazedemo.screenplay.interactions.Click;
import com.blazedemo.screenplay.interactions.Enter;
import com.blazedemo.screenplay.interactions.SelectFromOptions;
import com.blazedemo.screenplay.ui.HomePage;
import com.blazedemo.screenplay.ui.ReservePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchFlights implements Task {
    private final String fromPort;
    private final String toPort;

    private SearchFlights(String fromPort, String toPort) {
        this.fromPort = fromPort;
        this.toPort = toPort;
    }

    public static SearchFlights from(String fromPort) {
        return new SearchFlights(fromPort, null);
    }

    public SearchFlights to(String toPort) {
        return new SearchFlights(this.fromPort, toPort);
    }

    public static SearchFlights fromTo(String fromPort, String toPort) {
        return new SearchFlights(fromPort, toPort);
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(fromPort).from(HomePage.FROM_PORT),
                SelectFromOptions.byVisibleText(toPort).from(HomePage.TO_PORT),
                Click.on(HomePage.FIND_FLIGHTS_BUTTON)
        );
        // Wait for results page to load - both title and flight table
        actor.attemptsTo(WaitUntil.the(ReservePage.RESULTS_TITLE, isVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(WaitUntil.the(ReservePage.FLIGHT_ROWS, isVisible()).forNoMoreThan(30).seconds());
    }
}