package com.example.retailwebsite.service.impl;

import com.example.retailwebsite.enums.ProductType;
import com.example.retailwebsite.model.Bill;
import com.example.retailwebsite.service.intface.Discount;

import com.example.retailwebsite.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PercentageDiscount implements Discount {
    private double percentage;

    @Override
    public double calculateDiscount(Bill bill) {
        double discount = 0;
        for (Product product : bill.getProducts()) {
            if ((product.getProductType().compareTo(ProductType.GROCERIES) != 0)) {
                discount += (product.getPrice() * percentage / 100);
            }
        }
        return discount;
    }
}

