package compeople.stepDefinitions;

import compeople.pages.AllPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BewerbungsFormulaSD {


    AllPages allPages = new AllPages();

    @When("füllt das Bewerbungsformular aus")
    public void füllt_das_bewerbungsformular_aus() {
    allPages.getBewerbungsFormularPage().fillForm("10.10.1990");
    }

    @Then("wird prüft, ob die Schaltfläche zum Absenden klickbar ist")
    public void prüft_ob_die_schaltfläche_zum_absenden_klickbar_ist() {
        Assert.assertTrue(allPages.getBewerbungsFormularPage().ifJetztBewerbenButtonClickable());
    }

    @When("füllt das Bewerbungsformular aus und gibt im Pflichtfeld Geburtsdatum im falschen Format ein")
    public void füllt_das_bewerbungsformular_aus_und_gibt_im_pflichtfeld_geburtsdatum_im_falschen_format_ein() {
        allPages.getBewerbungsFormularPage().fillFormWithInvalidBirthDate();
    }

    @And("klickt auf die Schaltfläche zum Absenden")
    public void klickt_auf_die_schaltfläche_zum_absenden() {
        allPages.getBewerbungsFormularPage().clickJetztBewerbenButton();
    }

    @Then("wird prüft, ob die Fehlermeldung {string} beinhaltet")
    public void sollte_die_fehlermeldung_angezeigt_werden(String errMsg) {
        Assert.assertTrue(allPages.getBewerbungsFormularPage().invalidBirthDateFormat(errMsg));
    }
}
