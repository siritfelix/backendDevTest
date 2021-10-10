package com.backend.devtest.service;

import com.backend.devtest.models.Product;

import reactor.core.publisher.Flux;

public interface ProductService {

  public Flux<Product> getSimilarProduct(Integer productId);

}
