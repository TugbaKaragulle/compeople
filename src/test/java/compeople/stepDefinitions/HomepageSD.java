package compeople.stepDefinitions;

import compeople.pages.AllPages;
import compeople.utilities.ReusableMethods;
import io.cucumber.java.en.*;

import javax.swing.text.Utilities;

public class HomepageSD {

    AllPages allPages = new AllPages();

    @When("Karriere tikla")
    public void karriere_tikla() {
       allPages.getHomepage().clickKarriere();

    }

    @When("offene stellen tikla")
    public void offene_stellen_tikla() {
        allPages.getKarriere().clickOffeneStellen();
    }

    @When("Quality assurance tikla")
    public void quality_assurance_tikla() {
        allPages.getKarriere().clickStellenAngebote("Testing");

    }

    @When("Jetzt bewerben'a tikla")
    public void jetzt_bewerben_a_tikla() {


    }

}
