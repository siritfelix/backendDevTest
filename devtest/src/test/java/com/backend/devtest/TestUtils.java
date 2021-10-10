package com.backend.devtest;

import java.util.Arrays;
import java.util.List;

import com.backend.devtest.models.Product;

public class TestUtils {
  public static final int ID_1 = 1;
  public static final int ID_2 = 2;
  public static final int ID_3 = 3;
  public static final int ID_4 = 4;
  public static final String GET_SIMILAR_PRODUCTS_ID_1 = "/1/similar";

  public static Product buildProduct(int id) {
    return Product.builder().id(String.valueOf(id)).build();
  }

  public static List<Integer> buildProductSimilar1() {
    return Arrays.asList(ID_2, ID_3, ID_4);
  }

}
