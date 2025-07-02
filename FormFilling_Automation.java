package seleniumtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
       WebDriver driver;
    WebDriverWait wait;

   @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
   @Test
  public void login() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("firstName")).sendKeys("Kishore");
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Kishore");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Char");
        driver.findElement(By.id("userEmail")).sendKeys("kicha@gmail.com");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");

        String day = "8", month = "April", year = "2005";
        WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
        dobInput.click();
        Thread.sleep(3000);
        new
        Select(driver.findElement(By.className("react-datepicker__year-select"))).selectByVisibleText(year);
        new
        Select(driver.findElement(By.className("react-datepicker__month-select"))).selectByVisibleText(month);
        List<WebElement> days =
        driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day')]"));
        for (WebElement d : days) {
        if (d.getText().equals(day) && d.isDisplayed()) {
        d.click();
        break;
        }
        }

        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='Reading']")).click();
        Thread.sleep(3000);

        WebElement uploadElement =
        driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        uploadElement.sendKeys("C:\\Users\\kishore\\OneDrive\\Pictures\\Saved
        Pictures");
        Thread.sleep(1000);

        driver.findElement(By.id("currentAddress")).sendKeys("abc city road");
        Thread.sleep(3000);

        WebElement stateElement = driver.findElement(By.id("state"));
        ((JavascriptExecutor)
        driver).executeScript("arguments[0].scrollIntoView(true);", stateElement);
        Thread.sleep(3000);

        ((JavascriptExecutor) driver).executeScript(
        "let ads = document.querySelectorAll('iframe'); ads.forEach(ad =>
        ad.style.display='none');");

        stateElement.click();
        WebElement stateOption = driver.findElement(By.xpath("//div[text()='NCR']"));
        stateOption.click();

        WebElement cityElement = driver.findElement(By.id("city"));
        cityElement.click();
        WebElement cityOption =
        driver.findElement(By.xpath("//div[text()='Delhi']"));
        cityOption.click();

        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
        submitBtn);
        Thread.sleep(3000);

    driver.quit();
  }

    
