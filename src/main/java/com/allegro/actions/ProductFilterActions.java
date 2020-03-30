package com.allegro.actions;

import com.allegro.pages.ArticleFilterPanelPage;
import com.allegro.pages.MainPage;
import org.springframework.stereotype.Service;

@Service
public class ProductFilterActions {

  private final ArticleFilterPanelPage articleFilterPanelPage;
  private final MainPage mainPage;

  public ProductFilterActions(final ArticleFilterPanelPage articleFilterPanelPage,
      final MainPage mainPage) {
    this.articleFilterPanelPage = articleFilterPanelPage;
    this.mainPage = mainPage;
  }

  public void filterUsedArticlesWithMinPrice(final int minPrice) {
    mainPage.closeConsentsIfExist();
    articleFilterPanelPage.markUsedArticle();
    articleFilterPanelPage.setMinimalPrice(minPrice);
  }
}
