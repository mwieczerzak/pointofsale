package com.mwieczerzak;

import com.mwieczerzak.repository.ProductRepository;
import com.mwieczerzak.dto.Product;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProductRepositoryTest {

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(productRepository.findByBarcode(111L)).thenReturn(buildProduct(111, "apple", new BigDecimal(2.00)));
        when(productRepository.findByBarcode(220L)).thenReturn(buildProduct(220, "orange", new BigDecimal(3.00)));
        when(productRepository.findByBarcode(120L)).thenThrow(new RuntimeException());
    }

    private Product buildProduct(long barcode, String name, BigDecimal price) {
        return new Product(barcode, name, price);
    }

    @org.junit.Test
    public void shouldFindByBarcode() {
        assertEquals(buildProduct(111, "apple", new BigDecimal(2.00)), productRepository.findByBarcode(111L));
        assertEquals(buildProduct(220, "orange", new BigDecimal(3.00)), productRepository.findByBarcode(220L));
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeException() {
        productRepository.findByBarcode(120L);
    }
}

