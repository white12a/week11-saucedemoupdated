package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");//email filed locator and send keys
        driver.findElement(By.id("password")).sendKeys("secret_sauce");// pass field and send keys
        driver.findElement(By.id("login-button")).click();// click on login button
        String actualMsg=driver.findElement(By.xpath("//div[@class='header_secondary_container']/span")).getText();// get text
        String expectedMsg="PRODUCTS";// expected msg
        Assert.assertEquals("products text not visible",expectedMsg,actualMsg);// validation
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");//email filed locator and send keys
        driver.findElement(By.id("password")).sendKeys("secret_sauce");// pass field and send keys
        driver.findElement(By.id("login-button")).click();// click on login button
        List<WebElement>number= driver.findElements(By.xpath("//div[@class='inventory_item']"));// list of elements
        int actualNum=number.size();// size of list
        int expectedNum=6;//
        Assert.assertEquals("6 images not displayed", actualNum,expectedNum);// validation
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
