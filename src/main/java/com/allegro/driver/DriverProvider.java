package com.allegro.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {

  private static final Logger LOGGER = LogManager.getLogger(DriverProvider.class);

  private WebDriver driver;
  private final Dimension resolution = new Dimension(1440, 900);

  public WebDriver getDriver() {
    if (Objects.isNull(driver)) {
      setupChromeDriver();
    }

    setupDriverAdditionalParameters();
    driver.manage().window().setSize(resolution);
    LOGGER.info("Started chrome");

    return driver;
  }

  private void setupDriverAdditionalParameters() {
    driver.manage().deleteAllCookies();
    driver.manage().window().setPosition(new Point(0, 0));
    driver.manage().timeouts().implicitlyWait(DriverConfig.MAX_OBJECT_TIMEOUT,
        TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(DriverConfig.MAX_PAGE_LOAD_TIME,
        TimeUnit.SECONDS);
  }

  private void setupChromeDriver() {
    WebDriverManager.getInstance(ChromeDriver.class).setup();
    driver = ChromeBrowser.setupDriver();
  }

  @PreDestroy
  public void closeDriver() {
    if (driver != null) {
      driver.close();
      driver.quit();
      LOGGER.info("Closed chrome driver");
      driver = null;
    }
  }
}
