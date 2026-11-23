# BlazeDemo Flight Booking - Screenplay + Serenity BDD

End-to-end UI automation of https://blazedemo.com/ (flight search, purchase and confirmation)
using the Screenplay pattern, Serenity BDD and Gherkin.

## Requirements
- JDK 17
- Google Chrome
- Gradle is provided through the wrapper (7.6.4), use `./gradlew`

## How to run
| Goal | Command |
|---|---|
| Full suite + report | `./gradlew clean test` |
| Happy path only (demo) | `./gradlew clean smokeTest -Ddemo.delay.ms=1500` |
| Headless (CI) | `./gradlew clean test -Dheadless.mode=true` |

The report is generated at `target/site/serenity/index.html`.
`demo.delay.ms` adds a pause (in milliseconds) after every UI action so the run can be followed on screen.

## Structure
```
src/main/java/com/blazedemo/screenplay/
  ui/              Targets (locators per page)
  tasks/           Business-level tasks (SearchFlights, ChooseFlight, FillPaymentForm, ...)
  interactions/    Low-level actions (Click, Enter, SelectFromOptions, DemoPause)
  questions/       Questions that return values from the UI
  models/          Test data (PaymentData)
src/test/java/com/blazedemo/screenplay/
  stepdefinitions/ Gherkin steps, where the assertions live
  runners/         Runner (full suite) and SmokeRunner (@smoke)
src/test/resources/features/flight_booking.feature
```

## Scenarios
- `@smoke`: complete happy path (search, choose, purchase, confirmation).
- `@regression`: city pairs (Scenario Outline).
- `@known-issue`: documents real defects of the site (fixed price on the purchase page,
  fixed flight, confirmation amount not matching the total, empty form and invalid card accepted).

## CI
`.github/workflows/serenity-report.yml` runs the suite headless and publishes the report to GitHub Pages.
