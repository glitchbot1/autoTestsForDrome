import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class seasideCar {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "../autoTestsForDrome/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://auto.drom.ru/ ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,800)", "");
    }

    @Test
    public void checkSeaside() {
        WebDriverWait waitbuttonTown = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement buttonTown = driver.findElement(By.linkText("Другой город"));
        waitbuttonTown.until(ExpectedConditions.elementToBeClickable(buttonTown));
        buttonTown.click();
        WebDriverWait waitChoiseTown = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement searchTown = driver.findElement(By.cssSelector("input[placeholder='поиск города, региона']"));
        searchTown.sendKeys("Приморский край");
        searchTown.sendKeys(Keys.ENTER);

        top20Company();
    }

    public void top20Company(){
        WebElement inputListMark = driver.findElement(By.cssSelector("input[placeholder='Марка']"));
        inputListMark.click();
        List<WebElement> selectMark = (List<WebElement>) driver.findElement(By.id("drpdwn"));
        System.out.println("<------------- The elements List -------------> " + selectMark);
    }

    @AfterClass
    public static void end() {
        driver.quit();
    }
}