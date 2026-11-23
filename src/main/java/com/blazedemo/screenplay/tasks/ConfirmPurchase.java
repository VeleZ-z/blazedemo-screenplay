package com.blazedemo.screenplay.tasks;

import com.blazedemo.screenplay.interactions.Click;
import com.blazedemo.screenplay.ui.PurchasePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConfirmPurchase implements Task {

    public static ConfirmPurchase now() {
        return new ConfirmPurchase();
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(Click.on(PurchasePage.PURCHASE_BUTTON));
    }
}