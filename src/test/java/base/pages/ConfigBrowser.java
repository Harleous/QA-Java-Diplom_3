package base.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static constants.BrowserConstant.BROWSER_IN_USE;

public class ConfigBrowser {

    public static WebDriver driver;
    public static WebDriver startDriver(){
        WebDriver driver = null;
        switch (BROWSER_IN_USE){
            case "Firefox" :
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            case "Chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "YandexBrowser" :
                ChromeOptions chromeOptions1 = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "yandexdriver");
                chromeOptions1.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions1);
                break;

            default:
                Assert.fail("Неправильное имя  браузера: " + BROWSER_IN_USE );
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
