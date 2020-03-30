package com.allegro.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.allegro.products.ProductInformationHolder;
import com.allegro.verificatiors.BasketVerifier;
import io.cucumber.java.en.Then;

public class BasketVerifySteps {

  private final BasketVerifier basketVerifier;
  private final ProductInformationHolder productInformationHolder;

  public BasketVerifySteps(final BasketVerifier basketVerifier,
      final ProductInformationHolder productInformationHolder) {
    this.basketVerifier = basketVerifier;
    this.productInformationHolder = productInformationHolder;
  }

  @Then("Basket contains selected article")
  public void basketContainsSelectedArticle() {
    assertThat(basketVerifier.isBasketEmpty()).isFalse();
    assertThat(basketVerifier.isProductInBasket(productInformationHolder)).isTrue();
  }
}
