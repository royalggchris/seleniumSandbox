package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver(); //for Firefox
	System.setProperty("webdriver.chrome.driver", "./chromedriver"); //for Chrome
	driver = new ChromeDriver(); //for Chrome
	//driver = new SafariDriver(); //for Safari. Does not working struggling to install Safari extension
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
	driver.get(baseUrl + "/");
    driver.findElement(By.id("gbqfq")).clear();
    driver.findElement(By.id("gbqfq")).sendKeys("cars");
    driver.findElement(By.id("gbqfb")).click();
    driver.findElement(By.linkText("Cars (film) - Wikipedia, the free encyclopedia")).click();
    driver.findElement(By.cssSelector("span.toctext")).click();
    driver.findElement(By.linkText("Golden Globe Award for Best Animated Feature Film")).click();
    driver.findElement(By.linkText("How to Train Your Dragon")).click();
    driver.findElement(By.cssSelector("img.thumbimage")).click();
    driver.findElement(By.cssSelector("img[alt=\"File:Toothlessconceptart.jpg\"]")).click();
    
    driver.get(baseUrl + "/");
    driver.findElement(By.id("gbqfq")).clear();
    driver.findElement(By.id("gbqfq")).sendKeys("avacado fries");
    driver.findElement(By.id("gbqfb")).click();
    driver.findElement(By.cssSelector("a.q.qs")).click();
    Thread.sleep(5000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
