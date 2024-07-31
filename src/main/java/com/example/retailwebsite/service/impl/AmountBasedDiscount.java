package com.example.retailwebsite.service.impl;

import com.example.retailwebsite.model.Bill;
import com.example.retailwebsite.service.intface.Discount;

public class AmountBasedDiscount implements Discount {
    @Override
    public double calculateDiscount(Bill bill) {
        return (int)(bill.getTotalAmount() / 100) * 5;
    }
}

