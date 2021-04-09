package spotify.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        //Create a Chrome driver. All test classes use this.

        System.setProperty("webdriver.chrome.driver", "D:\\java-selenium-lib\\chromedriver.exe");

        driver = new ChromeDriver();

        //Maximize Window

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /*@AfterClass
    public void teardown () {
        driver.quit();
    }*/
}