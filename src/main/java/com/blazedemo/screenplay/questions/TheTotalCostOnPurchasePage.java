package com.blazedemo.screenplay.questions;

import com.blazedemo.screenplay.ui.PurchasePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheTotalCostOnPurchasePage implements Question<String> {

    public static TheTotalCostOnPurchasePage displayed() {
        return new TheTotalCostOnPurchasePage();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = Text.of(PurchasePage.TOTAL_COST).answeredBy(actor);
        return text != null ? text.trim() : "";
    }
}