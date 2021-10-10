package com.backend.devtest.client;

import java.util.List;

import com.backend.devtest.config.ProductClientConfiguration;
import com.backend.devtest.models.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productClient", url = "${product.url}", configuration = ProductClientConfiguration.class)
public interface ProductClient {

  public static final String PRODUCT_ID = "product/{productId}";
  public static final String PRODUCT_ID_SIMILAR = "product/{productId}/similarids";

  @GetMapping(value = PRODUCT_ID, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Product getProductDetail(@PathVariable int productId);

  @GetMapping(value = PRODUCT_ID_SIMILAR, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public  List<Integer> getProductSimilar(@PathVariable int productId);

}
