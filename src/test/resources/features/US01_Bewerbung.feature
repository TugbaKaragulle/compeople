@Regression
Feature: Bewerbung über die Homepage von compeople

  Background: Benutzer öffnet die Startseite
    Given Der Benutzer geht zur Startseite

  @Bewerbung @E2E
  Scenario: Job suchen und Bewerbung starten
    When Der Benutzer klickt auf "Karriere" im Header
    And klickt auf der geöffneten Seite auf "Offene Stellen"
    And klickt auf "Ja, ich bin einverstanden" im Cookie-Banner
    And klickt auf Unternehmensbereich und wählt "Testing/Quality Assurance Engineering" aus
    And wählt beim Karrierelevel "Professional" aus
    And gibt "Testing" in das Stichwort-Feld ein
    And klickt auf die Schaltfläche Aktualisieren
    And klickt auf das Stellenangebot, das das Wort "Testing" beinhaltet
    And Startet den Bewerbungsprozess über die Schaltfläche Jetzt bewerben
    And Füllt das Bewerbungsformular aus
    Then Prüft, ob die Schaltfläche zum Absenden klickbar ist
