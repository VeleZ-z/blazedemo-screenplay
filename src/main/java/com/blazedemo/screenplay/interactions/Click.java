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
        demoPause();
    }

    private void demoPause() {
        String delayMs = System.getProperty("demo.delay.ms", "0");
        try {
            long ms = Long.parseLong(delayMs);
            if (ms > 0) {
                Thread.sleep(ms);
            }
        } catch (NumberFormatException | InterruptedException ignored) {
        }
    }
}