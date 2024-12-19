package com.example.ShoppingCart.repository;


import com.example.ShoppingCart.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    //List<ShoppingCart> findByCustomer_Id(Integer customerId);
}

