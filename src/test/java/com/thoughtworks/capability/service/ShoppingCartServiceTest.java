package com.thoughtworks.capability.service;

import com.thoughtworks.capability.repository.ShoppingCartRepository;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingCartServiceTest {
    private  final ShoppingCartRepository shoppingCartRepository=mock(ShoppingCartRepository.class);
    private final  ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);
    @Test
    void shouldReturnEmptyShoppingCartWhenHasNoProducts() {
        // given
        when(shoppingCartRepository.findAll()).thenReturn(Lists.emptyList());

        // when
        ShoppingCartResponse shoppingCartResponse = shoppingCartService.findShoppingCart();

        //then
        assertEquals(shoppingCartResponse.getProducts().size(),0);
        assertEquals(shoppingCartResponse.getTotalPrice(), BigDecimal.ZERO);


    }
}
