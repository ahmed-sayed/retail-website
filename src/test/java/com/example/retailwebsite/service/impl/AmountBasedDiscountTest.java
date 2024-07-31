package com.example.retailwebsite.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.retailwebsite.model.Bill;
import com.example.retailwebsite.service.impl.AmountBasedDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;

import java.util.ArrayList;

public class AmountBasedDiscountTest {

    @InjectMocks
    private AmountBasedDiscount discount;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateDiscount() {
        // Arrange
        Bill bill = new Bill("1",new ArrayList<>());
        bill.setTotalAmount(990.0); // $990 bill

        // Act
        double discountAmount = discount.calculateDiscount(bill);

        // Assert
        assertThat(discountAmount).isEqualTo(45.0); // $5 per $100
    }
}
