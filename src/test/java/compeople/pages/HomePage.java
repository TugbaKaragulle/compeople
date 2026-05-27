package compeople.pages;

import compeople.utilities.Driver;
import compeople.utilities.JavascriptUtils;
import compeople.utilities.ReusableMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver = Driver.getDriver();
    private static final Logger log = LogManager.getLogger(HomePage.class);

    private By karriere = By.xpath("(//a[@class='elementor-item'][normalize-space()='Karriere'])[1]");


    // ---------------- METHODS ----------------

//    public void clickHeaderMenu(String menuName) {
//        By headerMenuLocator = By.xpath("//ul[contains(@id, 'menu-1')]//a[normalize-space()='" + menuName + "']");
//        ReusableMethods.waitForElementToBeClickable(driver, headerMenuLocator, 10);
//        JavascriptUtils.clickElementByJS(headerMenuLocator);
////        ReusableMethods.clickElement(headerMenuLocator);
//        log.info("Im Header-Menü wurde auf '{}' geklickt.", menuName);
//    }

    public void clickHeaderMenu() {

        ReusableMethods.waitForElementToBeClickable(driver, karriere, 10);
        JavascriptUtils.clickElementByJS(karriere);
//        ReusableMethods.clickElement(headerMenuLocator);
        log.info("Im Header-Menü wurde auf geklickt.");
    }

}
