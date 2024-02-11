import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class seasideCar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "../autoTestsForDrome/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://auto.drom.ru/ ");
        driver.manage().window().maximize();

        JavascriptExecutor scroll =(JavascriptExecutor)driver;
        scroll.executeScript("window.scrollBy(0,700)","");

        WebElement buttonTown = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/a[7]"));
        buttonTown.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement inputTown = driver.findElement(By.className("react-autosuggest__input"));
        inputTown.click();
        inputTown.sendKeys("Приморский край");
    }
}
