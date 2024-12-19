package com.example.ShoppingCart.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseOrderDTO {

    private float amount;
    private int invoiceNumber;
    private String date;
    private String OrderDescription;
    private int orderId;

}
