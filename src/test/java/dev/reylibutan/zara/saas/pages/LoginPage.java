package dev.reylibutan.zara.saas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage extends BaseZaraPage<LoginPage> {
  private final static String URL = "http://sdpw9071app.dpwah.com:18010/zodiac/core/auth";

  @FindBy(css = "button[type=submit]")
  private WebElement loginBtn;

  @FindBy(id = "browser-compatibility-modal")
  private WebElement bmcModal;

  @FindBy(id = "continue-btn")
  private WebElement bmcContinueBtn;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void closeBrowserCompatibilityModalIVisible() {
    waitForPage(3000).until(elementToBeClickable(bmcContinueBtn));
    if (isElementDisplayed(bmcModal)) {
      bmcContinueBtn.click();
    }
  }

  public void loginAsSiteUser(String siteCode) {

  }

  @Override
  protected String getUrl() {
    return URL;
  }

  @Override
  protected void isLoaded() throws Error {
    isUrlLoaded();
  }
}
