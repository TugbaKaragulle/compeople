@Regression
Feature: Bewerbung über die Homepage von compeople

  Background: Benutzer öffnet die Startseite
    Given Der Benutzer geht zur Startseite

  @Bewerbung @E2E
  Scenario: Job suchen und Bewerbung starten
    When Karriere tikla
    And offene stellen tikla
    And Quality assurance tikla
    And Jetzt bewerben'a tikla
