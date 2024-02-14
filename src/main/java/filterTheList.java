
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class filterTheList {
    public static WebDriver driver;
    private final By cardSale = By.xpath("//span[@data-ftid='bull_title']/..");
    private final By nextPage = By.cssSelector("[data-ftid='component_pagination-item-next']");

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "../autoTestsForDrome/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://auto.drom.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        //Открываем окно браузера на максимальную ширину
        driver.manage().window().maximize();
    }

    @Test
    public void filterList() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,700)", "");
        WebElement cardSale = driver.findElement(By.xpath("//span[@data-ftid='bull_title']/.."));
        //выбор марки
        WebElement inputListMark = driver.findElement(By.cssSelector("input[placeholder='Марка']"));
        inputListMark.click();
        WebElement markCar = driver.findElement(By.xpath("//div[@role = 'option' and contains(text(), 'Toyota')]"));
        markCar.click();
        //выбор модели(тут я запуталсь, что лишне, но оно работает)
        WebDriverWait waitinputListModel = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement inputListModel = driver.findElement(By.cssSelector("input[placeholder='Модель']"));
        waitinputListModel.until(ExpectedConditions.elementToBeClickable(inputListModel));
        inputListModel.sendKeys("Harrier");
        inputListModel.click();
        WebElement modelCar = driver.findElement(By.xpath("//div[@role = 'option' and contains(text(), 'Harrier')]"));
        WebDriverWait waitModelCar = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitModelCar.until(ExpectedConditions.elementToBeClickable(modelCar));
        modelCar.click();
        //выбор топлива гибрид
        WebElement buttonFuel = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[2]/div[3]/div[2]/div[1]/button"));
        buttonFuel.click();
        WebElement gibridCar = driver.findElement(By.xpath("//div[@role = 'option' and contains(text(), 'Гибрид')]"));
        WebDriverWait waitGibridCar = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitGibridCar.until(ExpectedConditions.elementToBeClickable(gibridCar));
        gibridCar.click();        //выбор непроданных
        WebElement unsoldCar = driver.findElement(By.xpath("//label[text() = 'Непроданные']"));
        unsoldCar.click();
        //выбор года
        WebElement inputYearCar = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[2]/div[2]/div/div[1]/div[1]/button"));
        inputYearCar.click();
        WebElement yearCar = driver.findElement(By.xpath("//div[text() = '2016']"));
        yearCar.click();
        //кликаем на расширенный поиск
        WebElement extendedSearch = driver.findElement(By.cssSelector("[data-ftid='sales__filter_advanced-button'] "));
        extendedSearch.click();
        WebElement inputMilage = driver.findElement(By.cssSelector("[data-ftid='sales__filter_mileage-from']"));
        inputMilage.click();
        //показать подобранные автомобили
        WebElement showResult = driver.findElement(By.xpath("//div[text()='Показать']"));
        showResult.click();
        CheckCarYear();
        checkSoldCars();
        clickNextPage();
        System.out.println("Результат на второй странице");
        CheckCarYear();
        checkSoldCars();
    }

    public void CheckCarYear() {
        List<WebElement> cars = driver.findElements((By) cardSale);
        for (WebElement e : cars) {
            Assert.assertTrue("Ошибка! Год авто меньше заданного", Integer.parseInt(e.getText().split(", ")[1]) >= 2007);
        }
        System.out.println("Нет авто с годом меньше 2007");
    }

    public void checkSoldCars() {
        List<WebElement> cars = driver.findElements(cardSale);
        for (WebElement e : cars) {
            Assert.assertFalse(e.getCssValue("text-decoration").contains("line-through"));
        }
        System.out.println("Нет проданных авто ");
    }

    public void clickNextPage() {
        driver.findElement(nextPage).click();
    }

    @AfterClass
    public static void end() {
        driver.close();
        driver.quit();
    }
}