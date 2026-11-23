package com.blazedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmationPage {
    public static final Target CONFIRMATION_TABLE = Target.the("confirmation details table")
            .located(By.cssSelector("div.hero-unit table.table"));

    public static final Target TRANSACTION_ID = Target.the("transaction id")
            .located(By.xpath("//td[text()='Id']/following-sibling::td"));

    public static final Target STATUS = Target.the("status")
            .located(By.xpath("//td[text()='Status']/following-sibling::td"));

    public static final Target AMOUNT = Target.the("amount")
            .located(By.xpath("//td[text()='Amount']/following-sibling::td"));

    public static final Target CARD_NUMBER = Target.the("card number")
            .located(By.xpath("//td[text()='Card Number']/following-sibling::td"));

    public static final Target EXPIRATION = Target.the("expiration")
            .located(By.xpath("//td[text()='Expiration']/following-sibling::td"));

    public static final Target AUTH_CODE = Target.the("auth code")
            .located(By.xpath("//td[text()='Auth Code']/following-sibling::td"));

    public static final Target DATE = Target.the("date")
            .located(By.xpath("//td[text()='Date']/following-sibling::td"));

    public static final Target JSON_RESPONSE = Target.the("json response")
            .located(By.cssSelector("div.hero-unit pre"));
}