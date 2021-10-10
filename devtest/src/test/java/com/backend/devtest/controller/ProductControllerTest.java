package com.backend.devtest.controller;

import static org.mockito.Mockito.when;

import com.backend.devtest.TestUtils;
import com.backend.devtest.client.ProductClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@ApiTestConfig
public class ProductControllerTest {

  @MockBean
  private ProductClient productClient;

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void whenGetSimilarProductOk1() {
    
    when(productClient.getProductDetail(TestUtils.ID_2)).thenReturn(TestUtils.buildProduct(TestUtils.ID_3));
    when(productClient.getProductDetail(TestUtils.ID_3)).thenReturn(TestUtils.buildProduct(TestUtils.ID_2));
    when(productClient.getProductDetail(TestUtils.ID_4)).thenReturn(TestUtils.buildProduct(TestUtils.ID_4));
    when(productClient.getProductSimilar(TestUtils.ID_1)).thenReturn(TestUtils.buildProductSimilar1());
    webTestClient.get().uri(ProductControllers.URI.concat(TestUtils.GET_SIMILAR_PRODUCTS_ID_1)).exchange()
        .expectStatus().isOk();
  }

}
