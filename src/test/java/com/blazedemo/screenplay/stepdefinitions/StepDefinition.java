package com.blazedemo.screenplay.stepdefinitions;

import com.blazedemo.screenplay.models.PaymentData;
import com.blazedemo.screenplay.questions.TheAirlineOnReservePage;
import com.blazedemo.screenplay.questions.TheConfirmationAmount;
import com.blazedemo.screenplay.questions.TheConfirmationStatus;
import com.blazedemo.screenplay.questions.TheConfirmationTransactionId;
import com.blazedemo.screenplay.questions.TheFlightCount;
import com.blazedemo.screenplay.questions.TheFlightOnPurchasePage;
import com.blazedemo.screenplay.questions.ThePriceOnPurchasePage;
import com.blazedemo.screenplay.questions.TheTotalCostOnPurchasePage;
import com.blazedemo.screenplay.tasks.ChooseFlight;
import com.blazedemo.screenplay.tasks.ConfirmPurchase;
import com.blazedemo.screenplay.tasks.FillPaymentForm;
import com.blazedemo.screenplay.tasks.OpenHomePage;
import com.blazedemo.screenplay.tasks.SearchFlights;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isEmptyString;

public class StepDefinition {

    private Actor user;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("user");
    }

    @After
    public void tearDown() {
        OnStage.drawTheCurtain();
    }

    @Given("the user is on the BlazeDemo homepage")
    public void theUserIsOnTheBlazeDemoHomepage() {
        user.attemptsTo(OpenHomePage.now());
    }

    @When("the user searches flights from {string} to {string}")
    public void theUserSearchesFlightsFromTo(String from, String to) {
        user.attemptsTo(SearchFlights.fromTo(from, to));
    }

    @When("the user chooses a flight from the results")
    public void theUserChoosesAFlightFromTheResults() {
        user.attemptsTo(ChooseFlight.firstAvailable());
    }

    @When("the user chooses flight {string}")
    public void theUserChoosesFlight(String flightNumber) {
        user.attemptsTo(ChooseFlight.byFlightNumber(flightNumber));
    }

    @When("the user chooses a flight operated by {string}")
    public void theUserChoosesAFlightOperatedBy(String airline) {
        user.attemptsTo(ChooseFlight.byAirline(airline));
    }

    @When("the user purchases the flight with valid payment details")
    public void theUserPurchasesTheFlightWithValidPaymentDetails() {
        user.attemptsTo(
                FillPaymentForm.withValidData(),
                ConfirmPurchase.now()
        );
    }

    @When("the user submits the purchase form with empty fields")
    public void theUserSubmitsThePurchaseFormWithEmptyFields() {
        user.attemptsTo(
                FillPaymentForm.withEmptyData(),
                ConfirmPurchase.now()
        );
    }

    @When("the user submits the purchase form with an invalid credit card number")
    public void theUserSubmitsThePurchaseFormWithAnInvalidCreditCardNumber() {
        user.attemptsTo(
                FillPaymentForm.withInvalidCard(),
                ConfirmPurchase.now()
        );
    }

    @Then("the results page should display available flights")
    public void theResultsPageShouldDisplayAvailableFlights() {
        user.should(seeThat(TheFlightCount.onResultsPage(), greaterThan(0)));
    }

    @Then("the purchase page should show the fixed price {int}")
    public void thePurchasePageShouldShowTheFixedPrice(int expectedPrice) {
        user.should(seeThat(ThePriceOnPurchasePage.displayed(), containsString(String.valueOf(expectedPrice))));
    }

    @Then("the purchase page should still show flight {string}")
    public void thePurchasePageShouldStillShowFlight(String expectedFlight) {
        user.should(seeThat(TheFlightOnPurchasePage.flightNumber(), equalTo(expectedFlight)));
    }

    @Then("the confirmation amount should differ from the purchase page total cost")
    public void theConfirmationAmountShouldDifferFromThePurchasePageTotalCost() {
        user.should(seeThat(
                TheConfirmationAmount.displayed(),
                not(equalTo(TheTotalCostOnPurchasePage.displayed().answeredBy(user)))
        ));
    }

    @Then("the confirmation page should display a transaction Id")
    public void theConfirmationPageShouldDisplayATransactionId() {
        user.should(seeThat(TheConfirmationTransactionId.displayed(), not(isEmptyString())));
    }

    @Then("the confirmation status should be {string}")
    public void theConfirmationStatusShouldBe(String expectedStatus) {
        user.should(seeThat(TheConfirmationStatus.displayed(), equalTo(expectedStatus)));
    }

    @Then("the confirmation should display an amount")
    public void theConfirmationShouldDisplayAnAmount() {
        user.should(seeThat(TheConfirmationAmount.displayed(), not(isEmptyString())));
    }
}