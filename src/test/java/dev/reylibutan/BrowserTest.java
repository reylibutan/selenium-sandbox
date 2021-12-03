package dev.reylibutan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserTest {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    WebDriver driver = new ChromeDriver();
    try {
      // open the site
      driver.get("https://phptravels.net/api/admin");

      // we declare a wait for login button
      int maxWaitInSeconds = 10;
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitInSeconds));

      // either element with "span.ladda-label" is clickable or maxWaitInSeconds is hit
      WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.ladda-label")));

      // TODO: type email
      // TODO: type password
      // TODO: click login
      // TODO: wait for page?
      // TODO: check page after login
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      driver.quit();
    }
  }
}
