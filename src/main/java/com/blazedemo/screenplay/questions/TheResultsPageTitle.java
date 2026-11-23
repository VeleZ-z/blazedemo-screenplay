package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ReservePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheResultsPageTitle implements Question<String> {

    public static TheResultsPageTitle displayed() {
        return new TheResultsPageTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(ReservePage.RESULTS_TITLE).answeredBy(actor);
        return text != null ? text.trim() : "";
    }
}