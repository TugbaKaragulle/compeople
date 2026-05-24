package compeople.pages;

import compeople.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Services {


    private WebDriver driver = Driver.getDriver();
    private static final Logger log = LogManager.getLogger(Services.class);

    public Services() {
        PageFactory.initElements(driver, this);
    }

    //Elemente

    private By automation = By.cssSelector("div.elementor-element-0ef673a");
    private By cloud = By.cssSelector("div.elementor-element-6b7b21b");
    private By dataAI = By.cssSelector("div.elementor-element-030fd07");
    private By experience = By.cssSelector("div.elementor-element-2f722ed");


}
