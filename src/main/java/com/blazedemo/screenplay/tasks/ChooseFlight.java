package com.blazedemo.screenplay.tasks;

import com.blazedemo.screenplay.interactions.Click;
import com.blazedemo.screenplay.ui.ReservePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public class ChooseFlight implements Task {

    private final Target chooseButton;

    private ChooseFlight(Target chooseButton) {
        this.chooseButton = chooseButton;
    }

    public static ChooseFlight firstAvailable() {
        return new ChooseFlight(ReservePage.FIRST_CHOOSE_BUTTON);
    }

    /** Chooses the flight by the number shown in the flight number column, e.g. "9696" or "12". */
    public static ChooseFlight byFlightNumber(String code) {
        return new ChooseFlight(ReservePage.chooseButtonForFlightNumber(code.replaceAll("\\D", "")));
    }

    public static ChooseFlight byAirline(String airline) {
        return new ChooseFlight(ReservePage.chooseButtonForAirline(airline));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(chooseButton));
    }
}
