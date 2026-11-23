package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.ConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheConfirmationTransactionId implements Question<String> {

    public static TheConfirmationTransactionId displayed() {
        return new TheConfirmationTransactionId();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(ConfirmationPage.TRANSACTION_ID).answeredBy(actor);
        return text != null ? text.trim() : "";
    }
}