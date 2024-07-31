package com.example.retailwebsite.service.intface;

import com.example.retailwebsite.model.Bill;

public interface Discount {
    double calculateDiscount(Bill bill);
}
