package dev.reylibutan.zara.saas.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static dev.reylibutan.zara.saas.util.Constants.DEFAULT_PAGE_LOAD_WAIT;
import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseZaraPage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

  protected WebDriver driver;

  public BaseZaraPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  protected abstract String getUrl();

  protected void postLoad() {
  }

  @Override
  protected void load() {
    driver.get(getUrl());
    postLoad();
  }

  @Override
  protected void isLoaded() throws Error {
    isUrlLoaded();
  }

  public WebDriverWait waitForPage() {
    return waitForPage(DEFAULT_PAGE_LOAD_WAIT);
  }

  public WebDriverWait waitForPage(int ms) {
    return new WebDriverWait(driver, ofMillis(ms));
  }

  public void isUrlLoaded() {
    assertEquals(driver.getCurrentUrl(), getUrl(), "URL is not loaded. (url = " + getUrl() + ")");
  }

  public boolean isElementDisplayed(WebElement we) {
    try {
      return we.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
