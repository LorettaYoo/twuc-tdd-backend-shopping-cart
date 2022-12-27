package com.thoughtworks.capability.repository;

import com.thoughtworks.capability.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoppingCartRepository extends JpaRepository<Product,Long> {

    @Override
    List<Product> findAll();
}
