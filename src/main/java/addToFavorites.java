import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class addToFavorites {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "../autoTestsForDrome/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

            driver.get("http://auto.drom.ru/ ");

            //Открываем окно браузера на максимальную ширину
            driver.manage().window().maximize();

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

            WebElement addfavorites = driver.findElement(By.xpath("//button[contains(@aria-label, 'Добавить в избранное')]\""));
            addfavorites.click();

            driver.close();
            driver.quit();

    }
}