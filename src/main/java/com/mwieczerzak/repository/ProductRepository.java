package com.mwieczerzak.repository;

import com.mwieczerzak.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public Product findByBarcode(Long barcode) {
        return products.stream()
                .filter(product -> product.getBarcode() == barcode)
                .findFirst()
                .orElseThrow(() -> new RuntimeException());
    }

}
