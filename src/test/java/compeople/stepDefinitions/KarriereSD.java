package compeople.stepDefinitions;

import compeople.pages.AllPages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KarriereSD {

    AllPages allPages = new AllPages();


    @When("klickt auf der geöffneten Seite auf {string}")
    public void der_benutzer_klickt_auf_der_geöffneten_seite_auf(String cardName) {
        allPages.getKarriere().clickKarriereCard(cardName);
    }

    @When("klickt auf {string} im Cookie-Banner")
    public void der_benutzer_klickt_auf_im_cookie_banner(String cookieOption) {
        allPages.getKarriere().handleCookieBanner(cookieOption);

    }

    @When("klickt auf Unternehmensbereich und wählt {string} aus")
    public void der_benutzer_klickt_auf_unternehmensbereich_und_wählt_aus(String bereich) {
        allPages.getKarriere().scrollAndSelectSection(bereich);

    }

    @When("wählt beim Karrierelevel {string} aus")
    public void der_benutzer_wählt_beim_karrierelevel_aus(String level) {
        allPages.getKarriere().selectKarriereLevel(level);

    }

    @When("gibt {string} in das Stichwort-Feld ein")
    public void der_benutzer_gibt_in_das_stichwort_feld_ein(String word) {
        allPages.getKarriere().sendStichwort(word);

    }

    @When("klickt auf die Schaltfläche Aktualisieren")
    public void der_benutzer_klickt_auf_die_schaltfläche_aktualisieren() {
        allPages.getKarriere().clickAktualisieren();
    }

    @Then("klickt auf das Stellenangebot, das das Wort {string} beinhaltet")
    public void der_benutzer_klickt_auf_das_stellenangebot_das_das_wort_beinhaltet(String position) {
        allPages.getKarriere().selectFilteredPosition(position);

    }

    @When("Startet den Bewerbungsprozess über die Schaltfläche Jetzt bewerben")
    public void startet_den_bewerbungsprozess_über_die_schaltfläche_jetzt_bewerben() {
        allPages.getKarriere().clickJetztBewerben();

    }


}
