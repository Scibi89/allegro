package com.allegro.actions;

import com.allegro.pages.MainPage;
import org.springframework.stereotype.Service;

@Service
public class ToolbarActions {

  private final MainPage mainPage;

  public ToolbarActions(final MainPage mainPage) {
    this.mainPage = mainPage;
  }

  public void searchForArticle(final String article) {
    mainPage.searchForArticle(article);
  }
}
