package com.allegro.pages;

import com.allegro.cfg.StoryProxyComponent;
import com.allegro.driver.DriverProvider;
import org.openqa.selenium.By;

@StoryProxyComponent
public class CurrentPage {

  private final DriverProvider driverProvider;

  public CurrentPage(final DriverProvider driverProvider) {
    this.driverProvider = driverProvider;
  }

  public boolean doPageContainsText(final String text) {
    return containsText(text);
  }

  private boolean containsText(final String text) {
    final By by = By.xpath("//*[contains(., '" + text + "')]");
    return (!driverProvider.getDriver().findElements(by).isEmpty());
  }
}
