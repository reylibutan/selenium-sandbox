package dev.reylibutan.zara.saas;

import dev.reylibutan.zara.saas.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

public class SaasTest {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    // login --------------------------------------------------------------------------------------
    loginPage.get();
    // check whether the browser compatibility modal is showing
    loginPage.closeBrowserCompatibilityModalIVisible();
    loginPage.loginAsSiteUser("S0A");

    try {
      Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      driver.quit();
    }
  }
}
