package com.mwieczerzak;

import com.mwieczerzak.dto.Product;
import com.mwieczerzak.model.Cart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AppTest {

    private Cart cart;
    private App app;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Product buildProduct(long barcode, String name, BigDecimal price) {
        return new Product(barcode, name, price);
    }

    @Before
    public void setup() {
        app = new App();
        cart = new Cart();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayAll() {
        cart.add(buildProduct(111, "apple", new BigDecimal(2.00)));
        cart.add(buildProduct(121, "orange", new BigDecimal(3.00)));
        app.displayAll(cart);
        String expected = "name = apple, price = 2" + "\r\n" + "name = orange, price = 3" + "\r\n" + "Total 5" + "\r\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintallProducts() {
        cart.add(buildProduct(111, "apple", new BigDecimal(2.00)));
        cart.add(buildProduct(121, "orange", new BigDecimal(3.00)));
        app.printAllProducts(cart);
    }

    @Test
    public void shouldScanBarcodeAndDisplayMessage1() {
        app.readBarcode("");
        String expected = "Invalid barcode" + "\r\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldScanBarcodeAndDisplayMessage2() {
        app.readBarcode("111");
        String expected = "Product not found" + "\r\n";
        assertEquals(expected, outContent.toString());
    }

}
