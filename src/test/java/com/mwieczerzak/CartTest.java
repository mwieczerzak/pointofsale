package com.mwieczerzak;

import com.mwieczerzak.dto.Product;
import com.mwieczerzak.model.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CartTest {

    private Cart cart;

    @BeforeEach
    public void setup(){
        cart = new Cart();
    }

    @Test
    public void shouldAddToCart() {
        cart.add(new Product(123456789, "Strawberry", new BigDecimal(3.00)));
        cart.add(new Product(223456789, "Raspberry", new BigDecimal(2.00)));
        cart.add(new Product(323456789, "Blueberry", new BigDecimal(2.50)));
        assertTrue(cart.getCartProducts().size() == 3);
    }
}
