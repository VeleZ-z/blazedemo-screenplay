package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheConfirmationStatus implements Question<String> {

    public static TheConfirmationStatus displayed() {
        return new TheConfirmationStatus();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(ConfirmationPage.STATUS).answeredBy(actor);
        return text != null ? text.trim() : "";
    }
}