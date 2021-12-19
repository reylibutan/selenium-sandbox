package dev.reylibutan.zara.saas;

import dev.reylibutan.zara.saas.pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.Sleeper.SYSTEM_SLEEPER;

public class CreateSiteTest {
  private static WebDriver driver;

  @BeforeAll
  static void setup() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    driver = new ChromeDriver();
  }

  @Test
  void createSite_shouldPass() {
    LoginPage loginPage = new LoginPage(driver);

    loginPage.get();
    // check whether the browser compatibility modal is showing
    loginPage.closeBrowserCompatibilityModalIVisible();
    loginPage.loginAsGlobalUser();
  }

  @AfterAll
  static void tearDown() {
    try {
      SYSTEM_SLEEPER.sleep(ofSeconds(10));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      driver.quit();
    }
  }
}
