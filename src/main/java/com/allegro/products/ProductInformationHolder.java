package com.allegro.products;

import com.allegro.cfg.StoryProxyComponent;
import java.util.Optional;

@StoryProxyComponent
public class ProductInformationHolder {

  private Optional<String> productName = Optional.empty();

  public String getProductName() {
    return productName.orElseThrow(() -> new IllegalStateException("Product name not found"));
  }

  public void setProductName(final String productName) {
    this.productName = Optional.ofNullable(productName);
  }
}
