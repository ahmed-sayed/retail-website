package com.example.retailwebsite.service.impl;

import com.example.retailwebsite.model.Bill;
import com.example.retailwebsite.model.User;

public class BillCalculatorService  {
    public double calculateNetPayableAmount(Bill bill, User user) {
        return bill.applyDiscount(user);
    }
}
