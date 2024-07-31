package com.example.retailwebsite.model;

import com.example.retailwebsite.enums.UserType;
import com.example.retailwebsite.service.impl.PercentageDiscount;
import com.example.retailwebsite.service.intface.Discount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String userId;
    private UserType userType;
    private int membershipDuration; // in years


    public Discount getDiscount() {
        switch (userType) {
            case EMPLOYEE:
                return new PercentageDiscount(30);
            case AFFILIATE:
                return new PercentageDiscount(10);
            case CUSTOMER:
                if (membershipDuration > 2) {
                    return new PercentageDiscount(5);
                }
                break;
            default:
                return null;
        }
        return null;
    }
}
