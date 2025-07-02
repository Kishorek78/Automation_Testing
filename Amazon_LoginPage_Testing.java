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
  
 public void login() throws InterruptedException, IOException{
    WebDriver driver = new ChromeDriver();
       driver.get("https://www.amazon.com/");
     driver.findElement(By.xpath("(//button[@class='a-button-text'])")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath(("//a[text()='Your Account']"))).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])")).click();
     WebElement sign=driver.findElement(By.xpath("(//input[@type='email'])"));
     sign.sendKeys("kishorecode78@gmail.com");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@type='submit']")).click();
     Thread.sleep(2000);
     WebElement pass=driver.findElement(By.xpath("(//input[@type='password'])"));
     pass.sendKeys("kishore78@K");
     driver.findElement(By.id("signInSubmit")).click();
 
  driver.quit();
 } 
