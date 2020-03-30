package com.allegro.pages;

import com.allegro.cfg.StoryProxyComponent;
import com.allegro.driver.DriverProvider;
import com.allegro.helpers.WaitService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@StoryProxyComponent
public class ArticleFilterPanelPage {

  private final WaitService waitService;

  @FindBy(xpath = "//a[contains(@href,'stan=u%C5%BCywane')]//..")
  private WebElement usedArticleCheckbox;

  @FindBy(id = "price_from")
  private WebElement priceFromField;

  public ArticleFilterPanelPage(final DriverProvider driverProvider,
      final WaitService waitService) {
    this.waitService = waitService;
    PageFactory.initElements(driverProvider.getDriver(), this);
  }

  public void markUsedArticle() {
    waitService.waitForElement(usedArticleCheckbox);
    usedArticleCheckbox.click();
  }

  public void setMinimalPrice(final int amount) {
    waitService.waitForElement(priceFromField);
    priceFromField.click();
    priceFromField.sendKeys(String.valueOf(amount));
  }
}
