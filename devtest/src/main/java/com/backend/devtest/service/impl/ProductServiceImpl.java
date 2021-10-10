package com.backend.devtest.service.impl;

import com.backend.devtest.client.ProductClient;
import com.backend.devtest.models.Product;
import com.backend.devtest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductClient productClient;

  @Autowired
  public ProductServiceImpl(ProductClient productClient) {
    this.productClient = productClient;
  }

  @Override
  public Flux<Product> getSimilarProduct(Integer productId) {

    return Flux
        .fromStream(productClient.getProductSimilar(productId).stream().map(id -> productClient.getProductDetail(id)));
  }

}
