package com.allegro.pages;

import com.allegro.cfg.StoryProxyComponent;

@StoryProxyComponent
public class PageOpener {

  private final MainPage mainPage;

  public PageOpener(final MainPage mainPage) {
    this.mainPage = mainPage;
  }

  public void openAndCloseConsents() {
    mainPage.openAndCloseConsents();
  }
}
