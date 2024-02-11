import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class filterTheList {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","../autoTestsForDrome/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://auto.drom.ru/ ");
        driver.manage().window().maximize();

        JavascriptExecutor scroll =(JavascriptExecutor)driver;
        scroll.executeScript("window.scrollBy(0,700)","");

        WebElement cardSale = driver.findElement(By.xpath("//span[@data-ftid='bull_title']/.."));

        //выбор марки
        WebElement inputListModel = driver.findElement(By.cssSelector("input[placeholder='Марка']")) ;
        inputListModel.click();
        WebElement modelCar= driver.findElement(By.xpath("//div[@role = 'option' and contains(text(), 'Toyota')]"));
        modelCar.click();

        //выбор модели
        //WebElement inputListMark = driver.findElement(By.cssSelector("input[placeholder='Модель']")) ;
        //inputListMark.click();

        //выбор топлива гибрид
        WebElement buttonFuel = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[2]/div[3]/div[2]/div[1]/button"));buttonFuel.click();
        WebElement gibridCar = driver.findElement(By.xpath("//div[text() = 'Гибрид']"));
        gibridCar.click();

        //выбор непроданных
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


        List<WebElement> carsNotSale = driver.findElements((By) cardSale);
        for (WebElement e : carsNotSale) {
                Assert.assertFalse(e.getCssValue("text-decoration").contains("line-through"));
        }

        List<WebElement> carsYaerMore2007 = driver.findElements((By) cardSale);
        for (WebElement e : carsYaerMore2007) {
            Assert.assertTrue("Ошибка! Год авто меньше заданного", Integer.parseInt(e.getText().split(", ")[1])>=2007);
        }


    }

    }

