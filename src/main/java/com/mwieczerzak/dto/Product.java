package com.mwieczerzak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {

    private long barcode;
    private String name;
    private BigDecimal price;

    public String toString() {
        return "name = " + name + ", price = " + price;
    }
}
