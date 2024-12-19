package com.example.ShoppingCart.controller;


import com.example.ShoppingCart.repository.CustomerRepository;
import com.example.ShoppingCart.repository.OrderRepository;
import com.example.ShoppingCart.repository.ProductRepository;
import com.example.ShoppingCart.repository.ShoppingCartRepository;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

private CustomerRepository customerRepository;
private OrderRepository orderRepository;
private ProductRepository productRepository;
private ShoppingCartRepository shoppingCartRepository;



@GetMapping("/products")
 public String showProducts(){

     return "products";
 }

}
