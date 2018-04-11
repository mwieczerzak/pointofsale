package com.mwieczerzak.devices.output;

import com.mwieczerzak.dto.Product;
import com.mwieczerzak.model.Cart;

import java.io.PrintWriter;

public interface Printer {

    void printProduct(PrintWriter printWriter, Product product);

    void printAllProducts(Cart cart);
}
