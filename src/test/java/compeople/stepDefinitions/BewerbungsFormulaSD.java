package compeople.stepDefinitions;

import compeople.pages.AllPages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BewerbungsFormulaSD {


    AllPages allPages = new AllPages();

    @When("Füllt das Bewerbungsformular aus")
    public void füllt_das_bewerbungsformular_aus() {
    allPages.getBewerbungsFormularPage().fillForm();

    }

    @Then("Prüft, ob die Schaltfläche zum Absenden klickbar ist")
    public void prüft_ob_die_schaltfläche_zum_absenden_klickbar_ist() {


    }
}
