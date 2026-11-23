package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.PurchasePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheFlightOnPurchasePage implements Question<String> {

    public static TheFlightOnPurchasePage flightNumber() {
        return new TheFlightOnPurchasePage();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(PurchasePage.FLIGHT_INFO_NUMBER).answeredBy(actor);
        if (text == null) return "";
        return text.replace("Flight Number:", "").trim();
    }
}