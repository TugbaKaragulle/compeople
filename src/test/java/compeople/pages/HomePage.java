package compeople.pages;

import compeople.utilities.Driver;
import compeople.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver = Driver.getDriver();
    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Elements

    private By services = By.xpath("//ul[contains(@id, 'menu-1')]//a[text()='Services']");
    private By News = By.xpath("//ul[contains(@id, 'menu-1')]//a[text()='News']");
    private By Karriere = By.xpath("//ul[contains(@id, 'menu-1')]//a[text()='Karriere']");
    private By uberUns = By.xpath("//ul[contains(@id, 'menu-1')]//a[text()='Über uns']");

    //Methods

    public void clickHeaderMenu(String menuName) {
        By dinamikHeaderMenu = By.xpath("//ul[contains(@id, 'menu-1')]//a[normalize-space()='" + menuName + "']");
        ReusableMethods.waitForElementToBeClickable(driver, dinamikHeaderMenu, 10);
        ReusableMethods.clickElement(dinamikHeaderMenu);
    }



}
