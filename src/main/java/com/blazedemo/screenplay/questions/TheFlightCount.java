package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ReservePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheFlightCount implements Question<Integer> {

    public static TheFlightCount onResultsPage() {
        return new TheFlightCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        var rows = ReservePage.FLIGHT_ROWS.resolveAllFor(actor);
        return rows.size();
    }
}