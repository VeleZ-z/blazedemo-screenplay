package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.PurchasePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ThePriceOnPurchasePage implements Question<String> {

    public static ThePriceOnPurchasePage displayed() {
        return new ThePriceOnPurchasePage();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(PurchasePage.PRICE_ON_PURCHASE).answeredBy(actor);
        if (text == null) return "";
        return text.replace("Price:", "").trim();
    }
}