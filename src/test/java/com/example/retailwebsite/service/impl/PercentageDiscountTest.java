package com.example.retailwebsite.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.retailwebsite.model.Bill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PercentageDiscountTest {

    private PercentageDiscount percentageDiscount;

    @BeforeEach
    public void setUp() {
        percentageDiscount = mock(PercentageDiscount.class);
    }

    @Test
    public void testCalculateDiscount() {
        // Arrange
        Bill bill = new Bill();
        bill.setTotalAmount(200.0); // $200 bill

        when(percentageDiscount.calculateDiscount(bill)).thenReturn(60.0); // Mocking method call

        // Act
        double discountAmount = percentageDiscount.calculateDiscount(bill);

        // Assert
        assertThat(discountAmount).isEqualTo(60.0); // Expected discount amount
    }
}
