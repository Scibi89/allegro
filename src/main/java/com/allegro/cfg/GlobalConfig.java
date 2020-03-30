package com.allegro.cfg;

import com.allegro.driver.DriverProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.allegro"})
public class GlobalConfig {

  @StoryProxyBean
  public DriverProvider driverFactory() {
    return new DriverProvider();
  }
}
