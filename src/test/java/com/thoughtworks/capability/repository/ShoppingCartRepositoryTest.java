package com.thoughtworks.capability.repository;

import com.thoughtworks.capability.WebApplicationTest;
import com.thoughtworks.capability.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartRepositoryTest extends WebApplicationTest {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    void shouldReturnEmptyProducts() {
        // given

        // when
        List<Product> products = shoppingCartRepository.findAll();

        // then
        assertEquals(products.size(),0);
    }
}