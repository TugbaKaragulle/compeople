package compeople.stepDefinitions;

import compeople.pages.AllPages;

import io.cucumber.java.en.*;

public class HomepageSD {

    AllPages allPages = new AllPages();

    @When("Der Benutzer klickt auf {string} im Header")
    public void der_benutzer_klickt_auf_im_header(String menuName) {
        allPages.getHomepage().clickHeaderMenu();
    }
}
