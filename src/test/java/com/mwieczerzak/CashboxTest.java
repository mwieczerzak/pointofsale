package com.mwieczerzak;

import com.mwieczerzak.dto.Product;
import com.mwieczerzak.model.Cart;
import com.mwieczerzak.model.Cashbox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CashboxTest {

    private Cart cart;
    private Cashbox cashbox;

    @BeforeEach
    public void setup() {
        cart = new Cart();
        cashbox = new Cashbox();
    }

    @Test
    public void shouldGetTotalPrice() {
        Product product1 = new Product(123456789, "Strawberry", new BigDecimal(3.00));
        Product product2 = new Product(223456789, "Raspberry", new BigDecimal(2.00));
        cart.add(product1);
        cart.add(product2);
        assertEquals(product1.getPrice().add(product2.getPrice()), cashbox.getTotalPrice(cart));
    }

}
