package com.allegro.steps;

import com.allegro.actions.ProductFilterActions;
import com.allegro.actions.ToolbarActions;
import io.cucumber.java.en.When;

public class ToolbarSteps {

  private final ToolbarActions toolbarActions;
  private final ProductFilterActions productFilterActions;

  public ToolbarSteps(final ToolbarActions toolbarActions,
      final ProductFilterActions productFilterActions) {
    this.toolbarActions = toolbarActions;
    this.productFilterActions = productFilterActions;
  }

  @When("He search for used {word} article with price over {int} pln")
  public void heSearchUsedArticleWithPriceOverPln(final String basicProductType,
      final int minPrice) {
    toolbarActions.searchForArticle(basicProductType);
    productFilterActions.filterUsedArticlesWithMinPrice(minPrice);
  }
}
