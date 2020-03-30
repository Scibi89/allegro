package com.allegro.pages;

import com.allegro.cfg.StoryProxyComponent;
import com.allegro.driver.DriverProvider;
import com.allegro.helpers.WaitService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@StoryProxyComponent
public class MainPage {

  private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

  private static final String MAIN_PAGE_URL = "https://allegro.pl/";
  private final DriverProvider driverProvider;
  private final WaitService waitService;

  @FindBy(xpath = "//input[@type='search']")
  private WebElement searchInputField;

  @FindBy(xpath = "//button[@data-role='search-button']")
  private WebElement searchButton;

  @FindBy(xpath = "//button[@data-role='accept-consent']")
  private WebElement acceptConsent;

  @FindBy(xpath = "(//div[@id='opbox-listing--base']//article)[1]")
  private WebElement firstArticleFromTop;

  public MainPage(final DriverProvider driverProvider, final WaitService waitService) {
    this.waitService = waitService;
    PageFactory.initElements(driverProvider.getDriver(), this);
    this.driverProvider = driverProvider;
  }

  public void openAndCloseConsents() {
    driverProvider.getDriver().get(MAIN_PAGE_URL);
    closeConsents();
  }

  public void closeConsents() {
    waitService.waitForElement(acceptConsent);
    acceptConsent.click();
  }

  public void closeConsentsIfExist() {
    try {
      closeConsents();
    } catch (final TimeoutException e) {
      LOGGER.info("Not found consents popup");
    }
  }

  public void searchForArticle(final String article) {
    searchInputField.sendKeys(article);
    searchButton.click();
  }

  public void selectFirstProduct() {
    firstArticleFromTop.click();
  }
}
