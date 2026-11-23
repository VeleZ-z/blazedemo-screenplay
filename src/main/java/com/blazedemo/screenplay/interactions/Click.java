package com.blazedemo.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class Click implements Interaction {
    private final Target target;

    private Click(Target target) {
        this.target = target;
    }

    public static Click on(Target target) {
        return new Click(target);
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Click.on(target));
        DemoPause.delay();
    }

}