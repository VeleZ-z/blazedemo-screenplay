package com.blazedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class OpenHomePage implements Task {

    public static OpenHomePage now() {
        return new OpenHomePage();
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(Open.url("https://blazedemo.com/"));
    }
}