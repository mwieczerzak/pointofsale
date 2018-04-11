package com.mwieczerzak.model;

import com.mwieczerzak.dto.Product;

import java.math.BigDecimal;

public class Cashbox {

    public BigDecimal getTotalPrice(Cart cart) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : cart.getCartProducts()) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        return totalPrice;
    }


}
