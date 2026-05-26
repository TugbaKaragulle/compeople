package compeople.pages;

import com.github.javafaker.Faker;
import compeople.utilities.Driver;
import compeople.utilities.JavascriptUtils;
import compeople.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.Locale;

public class BewerbungsFormularPage {

    private WebDriver driver = Driver.getDriver();
    private static final Logger log = LogManager.getLogger(BewerbungsFormularPage.class);
    private Faker faker = new Faker(new Locale("de"));

    // ---------------- LOCATORS ----------------

    private By vorname = By.xpath("//input[@id='vorname']");
    private By nachname = By.xpath("//input[@id='nachname']");
    private By straße = By.xpath("//input[@id='strasse']");
    private By plz = By.xpath("//input[@id='plz']");
    private By ort = By.xpath("//input[@id='ort']");
    private By land = By.xpath("//span[@id='country-button']");
    private By landAntworten = By.xpath("//li[@class='ui-menu-item']");
    private By geburtsDatum = By.xpath("//input[@id='geburtsdatum']");
    private By telefon = By.xpath("//input[@id='telefon']");
    private By mail = By.xpath("//input[@id='mail']");
    private By eintritt = By.xpath("//input[@id='eintrittsdatum']");
    private By gehaltswunsch = By.xpath("//input[@id='gehaltswunsch']");
    private By wieGefunden = By.xpath("//span[@id='wie_gefunden-button']");
    private By wieGefundenAntworten = By.xpath("//li[@class='ui-menu-item']//div");
    private By whatsApp = By.xpath("//span[@id='whatsapp_opt-button']");
    private By whatsappAntworten = By.xpath("//ul[@id='whatsapp_opt-menu']/li");
    private By anschreibenInput = By.xpath("//input[@name='anschreiben']");
    private By lebenslaufInput = By.xpath("//input[@name='lebenslauf']");
    private By datenschutz = By.xpath("//i[@class='rexx fa']");
    private By jetztBewerben = By.xpath("//div[@id='btn_online_application_send']");
    private By topErrorMessage = By.xpath("//div[@id='group_error_4567']/p[1]");

    // ---------------- METHODS ----------------

    public void enterVorname(){
        JavascriptUtils.changeBackgroundColorByJS(vorname,"yellow");
        ReusableMethods.sendKeys(vorname, faker.name().firstName());
        log.info("Vorname wurde erfolgreich eingegeben.");
    }
    public void enterNachname(){
        JavascriptUtils.changeBackgroundColorByJS(nachname,"yellow");
        ReusableMethods.sendKeys(nachname, faker.name().lastName());
        log.info("Nachname wurde erfolgreich eingegeben.");
    }
    public void enterStraße(){
        JavascriptUtils.changeBackgroundColorByJS(straße,"yellow");
        ReusableMethods.sendKeys(straße,faker.address().streetName());
        log.info("Straße wurde erfolgreich eingegeben.");
    }
    public void enterPlz(){
        JavascriptUtils.changeBackgroundColorByJS(plz,"yellow");
        ReusableMethods.sendKeys(plz, faker.address().zipCode());
        log.info("Postleitzahl wurde erfolgreich eingegeben.");
    }
    public void enterOrt(){
        JavascriptUtils.changeBackgroundColorByJS(ort,"yellow");
        ReusableMethods.sendKeys(ort, faker.address().cityName());
        log.info("Ort wurde erfolgreich eingegeben.");
    }
    public void selectLand(String country){
        JavascriptUtils.changeBackgroundColorByJS(land,"yellow");
        By countryOption = By.xpath("//ul[@id='country-menu']//li[normalize-space()='" + country + "']");
        ReusableMethods.waitForElementToBeClickable(driver, land, 10);
        ReusableMethods.clickElement(land);
        ReusableMethods.clickElement(countryOption);
        log.info("Land wurde ausgewählt: " + country);
    }
    public void enterGeburtsdatum(String datum){
        JavascriptUtils.changeBackgroundColorByJS(geburtsDatum,"yellow");
        ReusableMethods.sendKeys(geburtsDatum, datum);
        driver.findElement(geburtsDatum).sendKeys(Keys.ESCAPE);
        log.info("Geburtsdatum wurde eingegeben:" + datum);
    }
    public void enterTelefon(){
        JavascriptUtils.changeBackgroundColorByJS(telefon,"yellow");
        ReusableMethods.sendKeys(telefon, faker.phoneNumber().cellPhone());
        log.info("Telefonnummer wurde erfolgreich eingegeben.");
    }
    public void enterMail(){
        JavascriptUtils.changeBackgroundColorByJS(mail,"yellow");
        ReusableMethods.sendKeys(mail, faker.internet().emailAddress());
        log.info("E-Mail-Adresse wurde erfolgreich eingegeben.");
    }
    public void enterEintritt(){
        JavascriptUtils.changeBackgroundColorByJS(eintritt,"yellow");
        ReusableMethods.sendKeys(eintritt, "01.07.2026");
        driver.findElement(eintritt).sendKeys(Keys.ESCAPE);
        log.info("Eintrittsdatum wurde eingegeben.");
    }
    public void enterGehaltswunsch(){
        JavascriptUtils.changeBackgroundColorByJS(gehaltswunsch,"yellow");
        ReusableMethods.sendKeys(gehaltswunsch, "40000");
        log.info("Gehaltswunsch wurde eingegeben.");
    }
    public void selectWieGefunden(String website){
        JavascriptUtils.changeBackgroundColorByJS(wieGefunden,"yellow");
        By webOption = By.xpath("//ul[@id='wie_gefunden-menu']//li[normalize-space()='" + website + "']");
        ReusableMethods.waitForElementToBeClickable(driver,wieGefunden , 10);
        ReusableMethods.clickElement(wieGefunden);
        ReusableMethods.clickElement(webOption);
        log.info("Quelle 'Wie gefunden' wurde ausgewählt: {}", website);
    }

    public void selectWhatsappAnswer(String yesOrNo){
        JavascriptUtils.changeBackgroundColorByJS(whatsApp,"yellow");
        By whatsAppOption = By.xpath("//ul[@id='whatsapp_opt-menu']/li[normalize-space()='" + yesOrNo + "']");
        ReusableMethods.waitForElementToBeClickable(driver, whatsApp,10);
        ReusableMethods.clickElement(whatsApp);
        ReusableMethods.clickElement(whatsAppOption);
        log.info("WhatsApp-Option wurde beantwortet:{}", yesOrNo);
    }

    public void clickDatenschutz(){
        JavascriptUtils.changeBackgroundColorByJS(datenschutz,"yellow");
        ReusableMethods.waitForElementToBeClickable(driver,datenschutz,10);
        ReusableMethods.clickElement(datenschutz);
        log.info("Datenschutzrichtlinien wurden akzeptiert.");
    }

    public void fillForm(String geburtsDatum) {
        enterVorname();
        enterNachname();
        enterStraße();
        enterPlz();
        enterOrt();
        selectLand("Deutschland");
        enterGeburtsdatum(geburtsDatum);
        enterTelefon();
        enterMail();
        enterEintritt();
        enterGehaltswunsch();
        selectWieGefunden("andere Jobbörse");
        selectWhatsappAnswer("Nein");
        ReusableMethods.uploadDatei(driver,anschreibenInput,"Anschreiben_Test.docx");
        ReusableMethods.uploadDatei(driver,lebenslaufInput,"Lebenslauf_Test.docx");
        clickDatenschutz();
        log.info("Das Bewerbungsformular wurde mit gültigen Daten ausgefüllt.");
    }

    public void fillFormWithInvalidBirthDate(){
        fillForm("1990.10.10");
        log.info("Das Bewerbungsformular wurde mit einem ungültigen Geburtsdatumsformat ausgefüllt.");
    }

    public void clickJetztBewerbenButton(){
        ReusableMethods.waitForElementToBeClickable(driver,jetztBewerben,10);
        ReusableMethods.clickElement(jetztBewerben);
        log.info("Auf den 'Jetzt bewerben' Button wurde geklickt.");
    }

    // ---------------- VALIDATIONS ----------------

    public boolean ifJetztBewerbenButtonClickable(){
        try {
            ReusableMethods.isClickableByWebDriverWait(jetztBewerben);
            log.info("Der 'Jetzt bewerben'-Button ist klickbar.");
            return true;
        } catch (Exception e) {
            log.warn("Der 'Jetzt bewerben'-Button ist momentan nicht klickbar veya wurde nicht gefunden.");
            return false;
        }
    }

    public boolean invalidBirthDateFormat(String expectedMsg) {
        try {
        ReusableMethods.waitForVisibility(driver, topErrorMessage,10);
        String actualMsg = driver.findElement(topErrorMessage).getText();
        log.info("Gefundener Text im Fehlerblock: '{}' | Erwarteter Teil: '{}'", actualMsg, expectedMsg);
        return actualMsg.contains(expectedMsg);
    } catch (Exception e) {
            log.warn("Fehlerblock konnte nicht gefunden werden oder ist leer: {}", topErrorMessage);
        return false;
    }
}








}
