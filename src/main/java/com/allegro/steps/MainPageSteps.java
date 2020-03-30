package com.allegro.steps;

import com.allegro.cfg.CucumberSpringTest;
import com.allegro.pages.PageOpener;
import com.allegro.products.ArticleSelector;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

@CucumberSpringTest
public class MainPageSteps {

  private final PageOpener pageOpener;
  private final ArticleSelector articleSelector;

  public MainPageSteps(final PageOpener pageOpener,
      final ArticleSelector articleSelector) {
    this.pageOpener = pageOpener;
    this.articleSelector = articleSelector;
  }

  @Given("Customer is on main page")
  public void customerIsOnMainPage() {
    pageOpener.openAndCloseConsents();
  }

  @And("He add first result to a basket")
  public void heAddFirstResultToABasket() {
    articleSelector.addToBasketFirstDisplayedArticle();
  }
}
