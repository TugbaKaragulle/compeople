package compeople.pages;

import compeople.utilities.Driver;
import compeople.utilities.JavascriptUtils;
import compeople.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class KarrierePage {

    WebDriver driver = Driver.getDriver();
    private static final Logger log = LogManager.getLogger(KarrierePage.class);
    Actions actions = new Actions(driver);

    //Elemente

    private By compeopleDNA = By.cssSelector("a.elementor-element-f211025");
    private By deineVorteil = By.cssSelector("a.elementor-element-4d130bc");
    private By offeneStellen = By.cssSelector("a.elementor-element-32cffcb");
    private By ausbildungUndStudium = By.cssSelector("a.elementor-element-0dbd065");
    private By allStellenAngebote = By.cssSelector("div.joboffer_title_text"); //List-> im moment neun Stellenangebote
    private By jetztBewerben = By.xpath("//a[text()='Jetzt bewerben!']");
    private By cookiesEinverstanden = By.xpath("//a[@aria-label='Ja, ich bin einverstanden']");
    private By unternehmensBereich = By.xpath("//span[normalize-space()='Unternehmensbereich']");
    private By testingQualityAssurance = By.xpath("//span[normalize-space()='Testing/Quality Assurance Engineering']");
    private By karrierelevel = By.xpath("//span[normalize-space()='Karrierelevel']");
    private By professional = By.xpath("//label[@for='ui-multiselect-taetigkeit-option-1']");
    private By junior = By.xpath("//label[@for='ui-multiselect-taetigkeit-option-0']");
    private By senior = By.xpath("//label[@for='ui-multiselect-taetigkeit-option-2']");
    private By aktualisieren = By.xpath("//a[normalize-space()='Aktualisieren']");
    private By stichwortInput = By.xpath("//input[@class='ac_input']");
    private By selectJob = By.xpath("//div[@class='joboffer_title_text joboffer_box']/*[contains(text(),'Testing')]");
    private By filteredPositions = By.xpath("//div[@class='joboffer_title_text joboffer_box']");


    public void clickKarriereCard(String cardName) {
        By karriereCardName = By.xpath("//div[normalize-space()='" + cardName + "']/ancestor::a");
        ReusableMethods.waitForElementToBeClickable(driver, karriereCardName, 10);
        ReusableMethods.clickElement(karriereCardName);
    }

    public void handleCookieBanner(String cookieOptions) {
        By cookie = By.xpath("//a[@aria-label='" + cookieOptions + "']");
        ReusableMethods.waitForElementToBeClickable(driver, cookie, 10);
        ReusableMethods.clickElement(cookie);
    }

    public void clickUnternehmensBereich() {
        ReusableMethods.waitForElementToBeClickable(driver, unternehmensBereich, 10);
        ReusableMethods.clickElement(unternehmensBereich);
    }

    public void selectUnternehmensBereich(String section) {
        By bereich = By.xpath("//span[normalize-space()='" + section + "']");
        ReusableMethods.waitForElementToBeClickable(driver, bereich, 10);
        ReusableMethods.clickElement(bereich);
    }

    public void scrollAndSelectSection(String section) {
        //JavascriptUtils.seiteLangsamNachUntenScrollen(driver,28);
        //JavascriptUtils.seiteLangsamNachObenScrollen(driver,23);
        clickUnternehmensBereich();
        selectUnternehmensBereich(section);
    }

    public void clickKarriereLevel() {
        ReusableMethods.waitForElementToBeClickable(driver, karrierelevel, 10);
        ReusableMethods.clickElement(karrierelevel);
    }

    public void selectKarriereLevel(String level) {
        clickKarriereLevel();
        By karriereLevel = By.xpath("//ul[contains(@class, 'ui-multiselect-checkboxes')]//span[normalize-space()='" + level + "']");
        ReusableMethods.waitForElementToBeClickable(driver, karriereLevel, 10);
        ReusableMethods.clickElement(karriereLevel);
    }

    public void clickStichtwortArea() {
        ReusableMethods.waitForElementToBeClickable(driver, stichwortInput, 10);
        ReusableMethods.clickElement(stichwortInput);
    }

    public void sendStichwort(String word) {
        clickStichtwortArea();
        ReusableMethods.sendKeys(stichwortInput,word);
    }

    public void clickAktualisieren() {
        ReusableMethods.waitForElementToBeClickable(driver, aktualisieren, 10);
        actions.moveToElement(driver.findElement(aktualisieren)).click().perform();
        ReusableMethods.waitForSeconds(3);
    }

    public void selectFilteredPosition(String position) {
        List<WebElement>jobs = new ArrayList<>(driver.findElements(filteredPositions));
        for (int i = 0; i < jobs.size(); i++) {
            String jobName = jobs.get(i).getText();
            if(jobName.contains(position)){
                jobs.get(i).click();
                break;
            }
            ReusableMethods.waitForSeconds(2);

        }
    }

    public void clickJetztBewerben(){
        ReusableMethods.waitForElementToBeClickable(driver, jetztBewerben, 10);
        ReusableMethods.clickElement(jetztBewerben);
    }


    }


