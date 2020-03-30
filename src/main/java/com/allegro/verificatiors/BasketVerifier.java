package com.allegro.verificatiors;

import com.allegro.pages.CurrentPage;
import com.allegro.products.ProductInformationHolder;
import org.springframework.stereotype.Service;

@Service
public class BasketVerifier {

  private static final String EMPTY_BASKET_TEXT = "Twój koszyk jest pusty";
  private final CurrentPage currentPage;

  public BasketVerifier(final CurrentPage currentPage) {
    this.currentPage = currentPage;
  }

  public boolean isProductInBasket(final ProductInformationHolder productInformationHolder) {
    return currentPage.doPageContainsText(
        productInformationHolder.getProductName());
  }

  public boolean isBasketEmpty() {
    return currentPage.doPageContainsText(
        EMPTY_BASKET_TEXT);
  }
}
