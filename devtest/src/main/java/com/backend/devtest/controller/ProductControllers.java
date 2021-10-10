package com.backend.devtest.controller;

import com.backend.devtest.models.Product;
import com.backend.devtest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping(ProductControllers.URI)
public class ProductControllers {
  public static final String URI = "/product";
  public static final String GET_SIMILAR_PRODUCTS = "/{id}/similar";

  private ProductService productService;

  @Autowired
  public ProductControllers(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping(GET_SIMILAR_PRODUCTS)
  public Flux<Product> getSimilarProducts(@PathVariable Integer id) {
    return productService.getSimilarProduct(id);
  }

}
