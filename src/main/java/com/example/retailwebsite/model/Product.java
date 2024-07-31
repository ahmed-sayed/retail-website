package com.example.retailwebsite.model;

import com.example.retailwebsite.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String productId;
    private ProductType productType;
    private double price;

}
