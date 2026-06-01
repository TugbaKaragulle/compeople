package compeople.utilities;

import org.openqa.selenium.*;
import static compeople.utilities.Driver.getDriver;

public class JavascriptUtils {


    public static void clickElementByJS(By by) {
        WebElement element = getDriver().findElement(by);
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    public static void changeBackgroundColorByJS(By by, String color) {
        WebElement element = getDriver().findElement(by);
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element); //without border
        //javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: " + color + "; border: 2px solid red;');", element); //with red Border
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void seiteLangsamNachUntenScrollen(WebDriver driver, int schritte) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            for (int i = 0; i < schritte; i++) {
                js.executeScript("window.scrollBy(0, 100);");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Das Scrollen wurde unterbrochen: " + e.getMessage());
        }
    }

    public static void seiteLangsamNachObenScrollen(WebDriver driver, int schritte) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            for (int i = 0; i < schritte; i++) {
                js.executeScript("window.scrollBy(0, -100);");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ReusableMethods.waitForSeconds(1);
    }


}
