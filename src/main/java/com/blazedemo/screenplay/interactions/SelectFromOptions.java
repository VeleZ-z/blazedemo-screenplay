package com.blazedemo.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFromOptions implements Interaction {
    private final Target target;
    private final String option;

    private SelectFromOptions(Target target, String option) {
        this.target = target;
        this.option = option;
    }

    public static SelectFromOptionsBuilder byVisibleText(String option) {
        return new SelectFromOptionsBuilder(option);
    }

    public static class SelectFromOptionsBuilder {
        private final String option;

        public SelectFromOptionsBuilder(String option) {
            this.option = option;
        }

        public SelectFromOptions from(Target target) {
            return new SelectFromOptions(target, option);
        }
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.SelectFromOptions.byVisibleText(option).from(target));
        DemoPause.delay();
    }

}