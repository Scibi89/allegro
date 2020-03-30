package com.allegro.driver;

public class DriverConfig {

  public static final int MAX_PAGE_LOAD_TIME = 20;
  public static final int MAX_OBJECT_TIMEOUT = 15;
  public static final int POLLING_TIME = 2;

  private DriverConfig() {
    throw new IllegalStateException("This class should not be instantiated!");
  }
}
