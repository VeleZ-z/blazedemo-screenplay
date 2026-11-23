package com.blazedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PurchasePage {
    public static final Target FLIGHT_INFO_AIRLINE = Target.the("airline on purchase page")
            .located(By.xpath("//p[contains(text(), 'Airline:')]"));

    public static final Target FLIGHT_INFO_NUMBER = Target.the("flight number on purchase page")
            .located(By.xpath("//p[contains(text(), 'Flight Number:')]"));

    public static final Target PRICE_ON_PURCHASE = Target.the("price on purchase page")
            .located(By.xpath("//p[contains(text(), 'Price:')]"));

    public static final Target TOTAL_COST = Target.the("total cost on purchase page")
            .located(By.xpath("//p[contains(text(), 'Total Cost:')]/em"));

    public static final Target INPUT_NAME = Target.the("name input")
            .located(By.id("inputName"));

    public static final Target INPUT_ADDRESS = Target.the("address input")
            .located(By.id("address"));

    public static final Target INPUT_CITY = Target.the("city input")
            .located(By.id("city"));

    public static final Target INPUT_STATE = Target.the("state input")
            .located(By.id("state"));

    public static final Target INPUT_ZIP_CODE = Target.the("zip code input")
            .located(By.id("zipCode"));

    public static final Target CARD_TYPE = Target.the("card type dropdown")
            .located(By.id("cardType"));

    public static final Target CREDIT_CARD_NUMBER = Target.the("credit card number input")
            .located(By.id("creditCardNumber"));

    public static final Target CREDIT_CARD_MONTH = Target.the("credit card month input")
            .located(By.id("creditCardMonth"));

    public static final Target CREDIT_CARD_YEAR = Target.the("credit card year input")
            .located(By.id("creditCardYear"));

    public static final Target NAME_ON_CARD = Target.the("name on card input")
            .located(By.id("nameOnCard"));

    public static final Target REMEMBER_ME = Target.the("remember me checkbox")
            .located(By.id("rememberMe"));

    public static final Target PURCHASE_BUTTON = Target.the("purchase flight button")
            .located(By.cssSelector("input[value='Purchase Flight']"));
}