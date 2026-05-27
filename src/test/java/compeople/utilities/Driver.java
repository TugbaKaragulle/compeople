package compeople.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //Singleton driver class
    private static WebDriver driver;
    public static ThreadLocal<String> browserThread = new ThreadLocal<>();

    private Driver() {
    }// new keyword'u ile bu classtan obje oluşturulmasının önüne geçilir.

    public static WebDriver getDriver() {

        if (driver == null) {//Driver daha önce oluşturulmamış ise

            String browser = ConfigReader.getProperty("browser");

            switch (browser) {

                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized"); // Ekranı kapla
                    options.addArguments("--window-size=1920,1080"); // Çözünürlüğü sabitle (Jenkins için)
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "chrome-headless":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;
                default:
                    ChromeOptions defaultOptions = new ChromeOptions();
                    defaultOptions.addArguments("--start-maximized");
                    defaultOptions.addArguments("--window-size=1920,1080");
                    driver = new ChromeDriver(defaultOptions);

            }

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    public static void setBrowser(String browserName) {
        browserThread.set(browserName);
    }

    public static void closeDriver() {
        if (driver != null) {//Driver daha önce kapatılmamışsa

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.quit();
            driver = null;//Kapanan drivera null ataması yaparak getDriver methodu ile tekrar çağrılabilmesini sağlıyoruz
        }
    }
}
