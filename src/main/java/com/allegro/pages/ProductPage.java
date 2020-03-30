package com.allegro.pages;

import com.allegro.cfg.StoryProxyComponent;
import com.allegro.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@StoryProxyComponent
public class ProductPage {

  @FindBy(id = "add-to-cart-button")
  private WebElement addToCartButton;

  @FindBy(xpath = "//a[@data-analytics-click-label='goToCart']")
  private WebElement goToBasketButton;

  @FindBy(xpath = "//div/meta[@itemprop='name']")
  private WebElement articleName;

  public ProductPage(final DriverProvider driverProvider) {
    PageFactory.initElements(driverProvider.getDriver(), this);
  }

  public void addArticleToBasket() {
    addToCartButton.click();
  }

  public void goToBasket() {
    goToBasketButton.click();
  }

  public String provideArticleNameFromMeta() {
    return articleName.getAttribute("content");
  }

}
