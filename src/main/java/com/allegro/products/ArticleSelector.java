package com.allegro.products;

import com.allegro.pages.MainPage;
import com.allegro.pages.ProductPage;
import org.springframework.stereotype.Service;

@Service
public class ArticleSelector {

  private final MainPage mainPage;
  private final ProductPage productPage;
  private final ProductInformationHolder productInformationHolder;

  public ArticleSelector(final MainPage mainPage, final ProductPage productPage,
      final ProductInformationHolder productInformationHolder) {
    this.mainPage = mainPage;
    this.productPage = productPage;
    this.productInformationHolder = productInformationHolder;
  }

  public void addToBasketFirstDisplayedArticle() {
    mainPage.closeConsentsIfExist();
    mainPage.selectFirstProduct();
    productInformationHolder.setProductName(productPage.provideArticleNameFromMeta());
    mainPage.closeConsentsIfExist();
    productPage.addArticleToBasket();
    productPage.goToBasket();
  }

}
