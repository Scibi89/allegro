package com.allegro.helpers;

import com.allegro.driver.DriverConfig;
import com.allegro.driver.DriverProvider;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.stereotype.Service;

@Service
public class WaitService {

  private final DriverProvider driverProvider;

  public WaitService(final DriverProvider driverProvider) {
    this.driverProvider = driverProvider;
  }

  public void waitForElement(final WebElement webElement) {
    final ExpectedCondition<WebElement> condition =
        ExpectedConditions.elementToBeClickable(webElement);
    waitUntilCondition(condition);
  }

  private <T> void waitUntilCondition(final ExpectedCondition<T> condition) {
    new FluentWait<>(this.driverProvider.getDriver())
        .withTimeout(Duration.ofSeconds(DriverConfig.MAX_PAGE_LOAD_TIME))
        .pollingEvery(Duration.ofSeconds(DriverConfig.POLLING_TIME))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class)
        .until(webDriver -> condition.apply(webDriver));
  }

}
