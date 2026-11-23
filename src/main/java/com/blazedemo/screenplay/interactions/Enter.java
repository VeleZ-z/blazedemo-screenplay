package com.blazedemo.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class Enter implements Interaction {
    private final Target target;
    private final String value;

    private Enter(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static EnterBuilder theValue(String value) {
        return new EnterBuilder(value);
    }

    public static class EnterBuilder {
        private final String value;

        public EnterBuilder(String value) {
            this.value = value;
        }

        public Enter into(Target target) {
            return new Enter(target, value);
        }
    }

    @Override
    public void performAs(Actor actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(value).into(target));
        DemoPause.delay();
    }

}