package com.example.retailwebsite.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.retailwebsite.enums.ProductType;
import com.example.retailwebsite.enums.UserType;
import com.example.retailwebsite.model.Bill;
import com.example.retailwebsite.model.Product;
import com.example.retailwebsite.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

public class BillCalculatorServiceTest {



    @InjectMocks
    private BillCalculatorService billCalculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testForEmployee() {
        // Arrange
        Bill bill = new Bill("1", getDummyProductsList());
        User user = new User("1", UserType.EMPLOYEE, 1);

        // Act
        double netAmount = billCalculatorService.calculateNetPayableAmount(bill, user);

        // Assert
        assertThat(netAmount).isEqualTo(775); // Total $1100 - Discount for Emp -->> $270_P + $55_A
    }

    @Test
    public void testForAffiliate() {
        // Arrange
        Bill bill = new Bill("2", getDummyProductsList());
        User user = new User("2", UserType.AFFILIATE, 1);

        // Act
        double netAmount = billCalculatorService.calculateNetPayableAmount(bill, user);

        // Assert
        assertThat(netAmount).isEqualTo(955); // Total $1100 - Discount for AFFILIATE -->> $90_P + $55_A
    }

    @Test
    public void testForCustomerHasMembershipDurationLessThan2Years() {
        // Arrange
        Bill bill = new Bill("3", getDummyProductsList());
        User user = new User("3", UserType.CUSTOMER, 1);

        // Act
        double netAmount = billCalculatorService.calculateNetPayableAmount(bill, user);

        // Assert
        assertThat(netAmount).isEqualTo(1045); // Total $1100 - Discount for Emp -->> $0_P + $55_A
    }

    @Test
    public void testForCustomerHasMembershipDurationMoreThan2Years() {
        // Arrange
        Bill bill = new Bill("4", getDummyProductsList());
        User user = new User("4", UserType.CUSTOMER, 3);

        // Act
        double netAmount = billCalculatorService.calculateNetPayableAmount(bill, user);

        // Assert
        assertThat(netAmount).isEqualTo(1000); // Total $1100 - Discount for Emp -->> $45_P + $55_A
    }


    private List<Product> getDummyProductsList() {

        Product p1 = new Product("1", ProductType.ELECTRONICS, 100);
        Product p2 = new Product("2", ProductType.GROCERIES, 200);
        Product p3 = new Product("3", ProductType.CLOTHING, 300);
        Product p500 = new Product("500", ProductType.FURNITURE, 500);

        return Arrays.asList(p1, p2, p3, p500);

    }
}
