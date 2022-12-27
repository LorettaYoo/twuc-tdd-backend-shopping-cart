package com.thoughtworks.capability.service;

import com.thoughtworks.capability.domain.Product;
import com.thoughtworks.capability.repository.ShoppingCartRepository;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartResponse findShoppingCart() {
        List<Product> products = shoppingCartRepository.findAll();

        BigDecimal totalPrice = products.stream()
                .map(Product::getPriceTotalAmount)
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        return new ShoppingCartResponse(products,totalPrice);

    }
}
