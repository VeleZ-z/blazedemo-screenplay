package com.blazedemo.screenplay.interactions;

/** Single place that slows the run down for live demos. Controlled by -Ddemo.delay.ms (default 0). */
public final class DemoPause {

    private DemoPause() { }

    public static void delay() {
        long ms = Long.getLong("demo.delay.ms", 0L);
        if (ms > 0) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
