package compeople.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

import static compeople.utilities.Driver.getDriver;

public class ReusableMethods {
    private static final Logger log = LogManager.getLogger(ReusableMethods.class);

    // CLICK METHODS------------------------------------------------------------------------------------------------------
    public static void clickElement(By by) {
        waitForSeconds(1);
        Driver.getDriver().findElement(by).click();
    }

    public static WebElement clickElementByWebDriverWait(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(by)));
    }

    // SENDKEYS METHODS------------------------------------------------------------------------------------------------------
    public static void sendKeys(By by, String data) {
        Driver.getDriver().findElement(by).sendKeys(data);
        waitForSeconds(1);
    }

    //ISCLICKABLE METHODS------------------------------------------------------------------------------------------------------
    public static boolean isClickableByWebDriverWait(By by) {
        try {
            clickElementByWebDriverWait(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //THREAD.SLEEP METHOD
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep was interrupted");
        }
    }

    //Waits for the page title to contain the given string.
    public static boolean waitForVisibilityOfTitle(String string) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.titleContains(string));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitForElementToBePrecense(WebDriver driver, By by, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static void uploadDatei(WebDriver driver, By locator, String fileName) {
        try {
            JavascriptUtils.changeBackgroundColorByJS(locator,"yellow");
            String filePath = System.getProperty("user.dir") + File.separator + fileName;
            WebElement fileInput = waitForElementToBePrecense(driver, locator, 10);
            fileInput.sendKeys(filePath);
            log.info("Das Dokument '" + fileName + "' wurde erfolgreich hochgeladen.");
        } catch (Exception e) {
            log.error("Fehler beim Hochladen des Dokuments '" + fileName + "': ", e);
        }
    }
}






