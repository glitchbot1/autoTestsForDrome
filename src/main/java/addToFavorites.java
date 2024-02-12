import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.*;
import java.util.concurrent.TimeUnit;



public class addToFavorites {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "../autoTestsForDrome/webdriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://auto.drom.ru/ ");

        //Открываем окно браузера на максимальную ширину
        driver.manage().window().maximize();
    }

    @Test
    public void loginPage(){

        // Авторизация
        WebElement autolLoginButton = driver.findElement(By.className("e1k6fwrt0"));
        autolLoginButton.click();

        WebElement inputSign = driver.findElement(By.id("sign"));
        ;
        inputSign.sendKeys("+79969383173");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.click();
        inputPassword.sendKeys("UtK7IzZ6XjCL");

        WebElement inputSignButton = driver.findElement(By.id("signbutton"));
        inputSignButton.click();

        WebElement addCar = driver.findElement(By.className("e157qrb60"));
        addCar.click();
        // Добавляем объявления в избранное
        JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
        scrollDown.executeScript("window.scrollBy(0,800)", "");
        WebElement buttonAddFavorites = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[10]/div/div[1]/a[1]/div[3]/div[3]/div/button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(buttonAddFavorites));

    }
    @AfterClass
    public static void end()
    {
        driver.quit();
    }
}