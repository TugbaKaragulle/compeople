package compeople.stepDefinitions;

import compeople.pages.AllPages;
import compeople.utilities.ConfigReader;
import compeople.utilities.Driver;
import compeople.utilities.ReusableMethods;
import io.cucumber.java.en.Given;

public class CommonSD {

        AllPages allPages = new AllPages();

        @Given("Der Benutzer geht zur Startseite")
        public void der_benutzer_geht_zur_startseite() {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            ReusableMethods.waitForVisibilityOfTitle("compeople");
        }

    }


