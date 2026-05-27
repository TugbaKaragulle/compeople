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

    // ---------------- LOCATORS ----------------

    private By karriere = By.xpath("(//a[@class='elementor-item'][normalize-space()='Karriere'])[1]");
    private By jetztBewerben = By.xpath("//a[text()='Jetzt bewerben!']");
    private By unternehmensBereich = By.xpath("//span[normalize-space()='Unternehmensbereich']");
    private By karrierelevel = By.xpath("//span[normalize-space()='Karrierelevel']");
    private By aktualisieren = By.xpath("//a[normalize-space()='Aktualisieren']");
    private By stichwortInput = By.xpath("//input[@class='ac_input']");
    private By filteredPositions = By.xpath("//div[@class='joboffer_title_text joboffer_box']");

    // ---------------- METHODS ----------------

    public void clickKarriereCard(String cardName) {
        By karriereCard = By.xpath("//div[normalize-space()='" + cardName + "']/ancestor::a");
        ReusableMethods.waitForElementToBeClickable(driver, karriereCard, 10);
        ReusableMethods.clickElement(karriereCard);
        log.info("Auf die Karriere-Karte '{}' wurde geklickt.", cardName);
    }



    public void handleCookieBanner(String cookieOption) {
        By cookie = By.xpath("//a[@aria-label='" + cookieOption + "']");
        ReusableMethods.waitForElementToBeClickable(driver, cookie, 10);
        ReusableMethods.clickElement(cookie);
        log.info("Cookie-Option '{}' wurde ausgewählt.", cookieOption);
    }

    public void clickUnternehmensBereich() {
        ReusableMethods.waitForElementToBeClickable(driver, unternehmensBereich, 10);
        ReusableMethods.clickElement(unternehmensBereich);
        log.info("'Unternehmensbereich'-Dropdown wurde geöffnet.");
    }

    public void selectUnternehmensBereich(String section) {
        By bereich = By.xpath("//span[normalize-space()='" + section + "']");
        ReusableMethods.waitForElementToBeClickable(driver, bereich, 10);
        ReusableMethods.clickElement(bereich);
        log.info("Unternehmensbereich '{}' wurde ausgewählt.", section);
    }

    public void scrollAndSelectSection(String section) {
        JavascriptUtils.seiteLangsamNachUntenScrollen(driver,28);
        JavascriptUtils.seiteLangsamNachObenScrollen(driver,23);
        clickUnternehmensBereich();
        selectUnternehmensBereich(section);
        log.info("Zum Bereich gescrollt und '{}' ausgewählt.", section);
    }

    public void clickKarriereLevel() {
        ReusableMethods.waitForElementToBeClickable(driver, karrierelevel, 10);
        ReusableMethods.clickElement(karrierelevel);
        log.info("'Karrierelevel'-Dropdown wurde geöffnet.");
    }

    public void selectKarriereLevel(String level) {
        clickKarriereLevel();
        By levelLocator  = By.xpath("//ul[contains(@class, 'ui-multiselect-checkboxes')]//span[normalize-space()='" + level + "']");
        ReusableMethods.waitForElementToBeClickable(driver, levelLocator , 10);
        ReusableMethods.clickElement(levelLocator );
        log.info("Karrierelevel '{}' wurde ausgewählt.", level);
    }

    public void clickStichtwortArea() {
        ReusableMethods.waitForElementToBeClickable(driver, stichwortInput, 10);
        ReusableMethods.clickElement(stichwortInput);
        log.info("Das Stichwortfeld wurde angeklickt.");
    }

    public void sendStichwort(String word) {
        clickStichtwortArea();
        ReusableMethods.sendKeys(stichwortInput,word);
        log.info("Stichwort '{}' wurde eingegeben.", word);
    }

    public void clickAktualisieren() {
        ReusableMethods.waitForElementToBeClickable(driver, aktualisieren, 10);
        actions.moveToElement(driver.findElement(aktualisieren)).click().perform();
        log.info("Auf 'Aktualisieren' wurde geklickt.");
    }

    public void selectFilteredPosition(String position) {
        ReusableMethods.waitForElementToBePrecense(driver, filteredPositions, 10);
        List<WebElement>jobs = new ArrayList<>(driver.findElements(filteredPositions));
        for (int i = 0; i < jobs.size(); i++) {
            String jobName = ReusableMethods.getTextOfElement(jobs.get(i));
            if(jobName.contains(position)){
                jobs.get(i).click();
                log.info("Die gefilterte Position '{}' wurde ausgewählt.", position);
                break;
            }
        }
    }

    public void clickJetztBewerben(){
        ReusableMethods.waitForElementToBeClickable(driver, jetztBewerben, 10);
        ReusableMethods.clickElement(jetztBewerben);
        log.info("Auf 'Jetzt bewerben!' wurde geklickt.");
    }


    }


