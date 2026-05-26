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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BewerbungsFormularPage {
    private WebDriver driver = Driver.getDriver();

    public BewerbungsFormularPage(){
        PageFactory.initElements(driver,this);
    }
    private static final Logger log = LogManager.getLogger(BewerbungsFormularPage.class);
    private Faker faker = new Faker(new Locale("de"));

    //Elements

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


    public void enterVorname(){
        JavascriptUtils.changeBackgroundColorByJS(vorname,"yellow");
        ReusableMethods.sendKeys(vorname, faker.name().firstName());
        log.info("Vorname eingegeben.");
    }
    public void enterNachname(){
        JavascriptUtils.changeBackgroundColorByJS(nachname,"yellow");
        ReusableMethods.sendKeys(nachname, faker.name().lastName());
        log.info("Nachname eingegeben.");
    }
    public void enterStraße(){
        JavascriptUtils.changeBackgroundColorByJS(straße,"yellow");
        ReusableMethods.sendKeys(straße,faker.address().streetName());
        log.info("Straße eingegeben.");
    }
    public void enterPlz(){
        JavascriptUtils.changeBackgroundColorByJS(plz,"yellow");
        ReusableMethods.sendKeys(plz, faker.address().zipCode());
        log.info("Postleitzahl eingegeben.");
    }
    public void enterOrt(){
        JavascriptUtils.changeBackgroundColorByJS(ort,"yellow");
        ReusableMethods.sendKeys(ort, faker.address().cityName());
        log.info("Ort eingegeben.");
    }
    public void selectLand(String country){
        JavascriptUtils.changeBackgroundColorByJS(ort,"yellow");
        ReusableMethods.waitForElementToBeClickable(driver, land, 10);
       ReusableMethods.clickElement(land);
        List<WebElement>allCountry = new ArrayList<>(driver.findElements(landAntworten));
        for(int i =0; i<allCountry.size(); i++){
            String countryName = ReusableMethods.getTextOfElement(allCountry.get(i));
            if (countryName.equals(country)){
                allCountry.get(i).click();
                break;
            }
        }
        log.info("Eine Land gewählt");
    }
    public void enterGeburtsdatum(){
        JavascriptUtils.changeBackgroundColorByJS(geburtsDatum,"yellow");
        ReusableMethods.sendKeys(geburtsDatum, "10.10.1990");
        driver.findElement(geburtsDatum).sendKeys(Keys.ESCAPE);
        log.info("Geburtsdatum eingegeben.");
    }
    public void enterTelefon(){
        JavascriptUtils.changeBackgroundColorByJS(telefon,"yellow");
        ReusableMethods.sendKeys(telefon, faker.phoneNumber().cellPhone());
        log.info("Telefonnummer eingegeben.");
    }
    public void enterMail(){
        JavascriptUtils.changeBackgroundColorByJS(mail,"yellow");
        ReusableMethods.sendKeys(mail, faker.internet().emailAddress());
        log.info("E-mail eingegeben.");
    }
    public void enterEintritt(){
        JavascriptUtils.changeBackgroundColorByJS(eintritt,"yellow");
        ReusableMethods.sendKeys(eintritt, "01.07.2026");
        driver.findElement(eintritt).sendKeys(Keys.ESCAPE);
        log.info("Eintrittsdatum eingegeben.");
    }
    public void enterGehaltswunsch(){
        JavascriptUtils.changeBackgroundColorByJS(gehaltswunsch,"yellow");
        ReusableMethods.sendKeys(gehaltswunsch, "40000");
        log.info("Gehaltswunsch eingegeben.");
    }
    public void selectWieGefunden(String website){
        JavascriptUtils.changeBackgroundColorByJS(wieGefunden,"yellow");
        By webOption = By.xpath("//ul[@id='wie_gefunden-menu']//li[normalize-space()='" + website + "']");
        ReusableMethods.waitForElementToBeClickable(driver,wieGefunden , 10);
        ReusableMethods.clickElement(wieGefunden);
        ReusableMethods.clickElement(webOption);
        log.info("Wie gefunden gewählt.");
    }

    public void selectWhatsappAnswer(String yesOrNo){
        JavascriptUtils.changeBackgroundColorByJS(whatsApp,"yellow");
        By whatsAppOption = By.xpath("//ul[@id='whatsapp_opt-menu']/li[normalize-space()='" + yesOrNo + "']");
        ReusableMethods.waitForElementToBeClickable(driver, whatsApp,10);
        ReusableMethods.clickElement(whatsApp);
        ReusableMethods.clickElement(whatsAppOption);
        log.info("WhatsApp info eingegeben.");
    }

    public void clickDatenschutz(){
        JavascriptUtils.changeBackgroundColorByJS(datenschutz,"yellow");
        ReusableMethods.waitForElementToBeClickable(driver,datenschutz,10);
        ReusableMethods.clickElement(datenschutz);
        log.info("Datenschutz wurde akzeptiert ");
    }

    public void fillForm() {
        enterVorname();
        enterNachname();
        enterStraße();
        enterPlz();
        enterOrt();
        selectLand("Deutschland");
        enterGeburtsdatum();
        enterTelefon();
        enterMail();
        enterEintritt();
        enterGehaltswunsch();
        selectWieGefunden("andere Jobbörse");
        selectWhatsappAnswer("Nein");
        ReusableMethods.uploadDatei(driver,anschreibenInput,"Anschreiben_Test.docx");
        ReusableMethods.uploadDatei(driver,lebenslaufInput,"Lebenslauf_Test.docx");
        clickDatenschutz();
    }

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


}
