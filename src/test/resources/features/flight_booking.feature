Feature: Flight Booking
  As a traveler
  I want to search flights and buy a ticket on BlazeDemo
  So that I get a confirmed booking with consistent prices and details

  Background:
    Given the user is on the BlazeDemo homepage

  @smoke @regression
  Scenario: Search flights, choose flight, purchase and verify confirmation
    When the user searches flights from "Paris" to "Rome"
    And the user chooses a flight from the results
    And the user purchases the flight with valid payment details
    Then the confirmation page should display a transaction Id
    And the confirmation status should be "PendingCapture"
    And the confirmation should display an amount

  @regression
  Scenario Outline: Search flights with different city pairs
    When the user searches flights from "<origin>" to "<destination>"
    Then the results page should display available flights
    Examples:
      | origin    | destination |
      | Paris     | Rome        |
      | Boston    | London      |
      | Portland  | New York    |

  @known-issue @regression
  Scenario Outline: Known issue: The purchase page shows a fixed price regardless of the chosen flight
    When the user searches flights from "Paris" to "Rome"
    And the user chooses flight "<flight>"
    Then the purchase page should show the fixed price 400
    Examples:
      | flight |
      | 9696  |
      | 12    |

  @known-issue @regression
  Scenario Outline: Known issue: The purchase page shows the same flight regardless of the chosen airline
    When the user searches flights from "Paris" to "Rome"
    And the user chooses a flight operated by "<airline>"
    Then the purchase page should still show flight "UA954"
    Examples:
      | airline    |
      | Lufthansa  |
      | Aer Lingus |

  @known-issue @regression
  Scenario: Known issue: The confirmation amount differs from the purchase page total
    When the user searches flights from "Paris" to "Rome"
    And the user chooses a flight from the results
    And the user purchases the flight with valid payment details
    Then the confirmation amount should differ from the purchase page total cost

  @known-issue @regression
  Scenario: Known issue: Submit empty purchase form shows confirmation
    When the user searches flights from "Paris" to "Rome"
    And the user chooses a flight from the results
    And the user submits the purchase form with empty fields
    Then the confirmation page should display a transaction Id
    And the confirmation status should be "PendingCapture"

  @known-issue @regression
  Scenario: Known issue: Submit invalid credit card shows confirmation
    When the user searches flights from "Paris" to "Rome"
    And the user chooses a flight from the results
    And the user submits the purchase form with an invalid credit card number
    Then the confirmation page should display a transaction Id
    And the confirmation status should be "PendingCapture"
