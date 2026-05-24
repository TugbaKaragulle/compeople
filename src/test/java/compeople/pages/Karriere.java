package compeople.pages;

import compeople.utilities.Driver;
import compeople.utilities.JavascriptUtils;
import compeople.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Karriere {

    WebDriver driver = Driver.getDriver();
    private static final Logger log = LogManager.getLogger(Karriere.class);

    //Elemente

    private By compeopleDNA = By.cssSelector("a.elementor-element-f211025");
    private By deineVorteil = By.cssSelector("a.elementor-element-4d130bc");
    private By offeneStellen = By.cssSelector("a.elementor-element-32cffcb");
    private By ausbildungUndStudium = By.cssSelector("a.elementor-element-0dbd065");
    private By allStellenAngebote = By.cssSelector("div.joboffer_title_text"); //List-> im moment neun Stellenangebote
    private By jetztBewerben = By.xpath("//a[text()='Jetzt bewerben!']");
    private By cookiesEinverstanden = By.xpath("//a[@aria-label='Ja, ich bin einverstanden']");
    private By unternehmensBereich = By.xpath("//span[normalize-space()='Unternehmensbereich']");

    public void clickOffeneStellen(){
        ReusableMethods.isClickableByWebDriverWait(offeneStellen);
        ReusableMethods.clickElement(offeneStellen);
        ReusableMethods.waitForSeconds(2);
        ReusableMethods.clickElement(cookiesEinverstanden);
        ReusableMethods.waitForSeconds(2);
    }

    public void clickStellenAngebote(String position){ // Klickt auf das Stellenangebot mit der angegebenen Position.
        JavascriptUtils.seiteLangsamNachUntenScrollen(driver,28);
        ReusableMethods.waitForSeconds(1);
        JavascriptUtils.seiteLangsamNachObenScrollen(driver,23);
        ReusableMethods.waitForSeconds(2);
        By jobLocator = By.xpath("//div[contains(@class,'joboffer_title_text') and contains(.,'"+ position + "')]");
        ReusableMethods.isClickableByWebDriverWait(jobLocator);
        driver.findElement(jobLocator).click();
    }


    }


