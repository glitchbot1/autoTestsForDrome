import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class filterTheList {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","../autoTestsForDrome/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://auto.drom.ru/ ");
        driver.manage().window().maximize();

        JavascriptExecutor scroll =(JavascriptExecutor)driver;
        scroll.executeScript("window.scrollBy(0,700)","");
        //выбор марки
        WebElement inputListModel = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[1]/div[1]/div"));
        inputListModel.click();
        WebElement modelCar = driver.findElement(By.xpath("//div[text() = 'Toyota (92027)']"));
        modelCar.click();

         //выбор модели
        // WebElement inputListMark = driver.findElement(By.className("css-tfkmus e1207tlp0"));
        // inputListMark.click();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//      WebElement inputListSelect = driver.findElement(By.xpath("//div[@data-ftid='component_select_dropdown']"));

//      WebDriverWait wait=new WebDriverWait(driver,  Duration.ofSeconds(30));
//      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//      By.xpath("//div[text() = 'Harrier (2137)']")));
//      element.click();


        //выбор топлива гибрид
        WebElement buttonFuel = driver.findElement(By.xpath(" /html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[2]/div[3]/div[2]/div[1]/button"));buttonFuel.click();
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
        WebElement extendedSearch = driver.findElement(By.xpath(" /html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[4]/div[2]/button"));
        extendedSearch.click();
        //показать подобранные автомобили
        WebElement showResult = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[3]/form/div/div[5]/div[3]/button"));
        showResult.click();


        }

    }

