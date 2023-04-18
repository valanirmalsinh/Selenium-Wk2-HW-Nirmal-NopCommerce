package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToRegisterPageSuccessfully(){
        driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
        String expectedMessage = "Register";
        WebElement actualElement = driver.findElement(By.xpath("//h1[text() ='Register']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Register", expectedMessage,actualMessage);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.name("FirstName")).sendKeys("Nirmal");
        driver.findElement(By.name("LastName")).sendKeys("Vala");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("1");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1981");
        driver.findElement(By.id("Email")).sendKeys("abcdef123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("abcdef123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abcdef123");
        driver.findElement(By.name("register-button")).click();
        String expectedMessage ="Your registration completed";
        WebElement actualElement = driver.findElement(By.xpath("//div[@class ='result']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Not found",expectedMessage,actualMessage);

    }

}
