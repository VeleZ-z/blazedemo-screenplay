package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheConfirmationAmount implements Question<String> {

    public static TheConfirmationAmount displayed() {
        return new TheConfirmationAmount();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(ConfirmationPage.AMOUNT).answeredBy(actor);
        return text != null ? text.trim() : "";
    }
}