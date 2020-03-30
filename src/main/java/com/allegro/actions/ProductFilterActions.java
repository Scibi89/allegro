package com.allegro.actions;

import com.allegro.pages.ArticleFilterPanelPage;
import org.springframework.stereotype.Service;

@Service
public class ProductFilterActions {

  private final ArticleFilterPanelPage articleFilterPanelPage;

  public ProductFilterActions(final ArticleFilterPanelPage articleFilterPanelPage) {
    this.articleFilterPanelPage = articleFilterPanelPage;
  }

  public void filterUsedArticlesWithMinPrice(final int minPrice) {
    articleFilterPanelPage.markUsedArticle();
    articleFilterPanelPage.setMinimalPrice(minPrice);
  }
}
