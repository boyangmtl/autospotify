package spotify.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public boolean findString(String keyword) {
        //System.out.println(this.driver.getPageSource());
        return this.driver.getPageSource().contains(keyword);



    }
    //Write Text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Reload page
    public void reloadPage() {
        this.driver.navigate().refresh();

    }


    //Read Attribute
    public String readAttribute(By elementBy, String fieldName) {
        waitVisibility(elementBy);

        return driver.findElement(elementBy).getAttribute(fieldName);
    }
    //Double click one element.

    public void doubleClickElement(By elementBy) {

        waitVisibility(elementBy);

        Actions tempClick = new Actions(this.driver);

        tempClick.doubleClick(this.driver.findElement(elementBy)).build().perform();


    }



    //Assert
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }
}