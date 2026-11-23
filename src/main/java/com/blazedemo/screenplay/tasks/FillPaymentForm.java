package com.blazedemo.screenplay.tasks;

import com.blazedemo.screenplay.interactions.Click;
import com.blazedemo.screenplay.interactions.Enter;
import com.blazedemo.screenplay.interactions.SelectFromOptions;
import com.blazedemo.screenplay.models.PaymentData;
import com.blazedemo.screenplay.ui.PurchasePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class FillPaymentForm implements Task {
    private final PaymentData paymentData;

    private FillPaymentForm(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    public static FillPaymentForm withValidData() {
        return new FillPaymentForm(PaymentData.valid());
    }

    public static FillPaymentForm withEmptyData() {
        return new FillPaymentForm(PaymentData.empty());
    }

    public static FillPaymentForm withInvalidCard() {
        return new FillPaymentForm(PaymentData.invalidCard());
    }

    public static FillPaymentForm with(PaymentData paymentData) {
        return new FillPaymentForm(paymentData);
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(
                Enter.theValue(paymentData.getName()).into(PurchasePage.INPUT_NAME),
                Enter.theValue(paymentData.getAddress()).into(PurchasePage.INPUT_ADDRESS),
                Enter.theValue(paymentData.getCity()).into(PurchasePage.INPUT_CITY),
                Enter.theValue(paymentData.getState()).into(PurchasePage.INPUT_STATE),
                Enter.theValue(paymentData.getZipCode()).into(PurchasePage.INPUT_ZIP_CODE),
                SelectFromOptions.byVisibleText(paymentData.getCardType()).from(PurchasePage.CARD_TYPE),
                Enter.theValue(paymentData.getCreditCardNumber()).into(PurchasePage.CREDIT_CARD_NUMBER),
                Enter.theValue(paymentData.getCreditCardMonth()).into(PurchasePage.CREDIT_CARD_MONTH),
                Enter.theValue(paymentData.getCreditCardYear()).into(PurchasePage.CREDIT_CARD_YEAR),
                Enter.theValue(paymentData.getNameOnCard()).into(PurchasePage.NAME_ON_CARD)
        );

        if (paymentData.isRememberMe()) {
            actor.attemptsTo(Click.on(PurchasePage.REMEMBER_ME));
        }
    }
}