package com.example.ShoppingCart.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Setter
@Getter
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {



    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int availableQuantity;
    private float price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", price=" + price +
                '}';
    }


}
