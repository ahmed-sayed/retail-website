package com.example.retailwebsite.model;

import com.example.retailwebsite.service.intface.Discount;
import com.example.retailwebsite.service.impl.AmountBasedDiscount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill {
    private String billId;
    private List<Product> products;
    private double totalAmount;

    public Bill(String billId, List<Product> products) {
        this.billId = billId;
        this.products = products;
        calculateTotal();
    }

    public double calculateTotal() {
        totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
        return totalAmount;
    }

    public double applyDiscount(User user) {
        double discountAmount = 0;
        Discount discount = user.getDiscount();
        if (discount != null) {
            discountAmount += discount.calculateDiscount(this);
        }

        // Apply $5 discount for every $100
        AmountBasedDiscount amountBasedDiscount = new AmountBasedDiscount();
        discountAmount += amountBasedDiscount.calculateDiscount(this);
        return totalAmount - discountAmount;
    }

}

