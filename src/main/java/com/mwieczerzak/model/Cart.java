package com.mwieczerzak.model;

import com.mwieczerzak.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> cartProducts = new ArrayList<>();

    public List<Product> getCartProducts() {
        return cartProducts;
    }

    public void add(Product product) {
        cartProducts.add(product);
    }
}
