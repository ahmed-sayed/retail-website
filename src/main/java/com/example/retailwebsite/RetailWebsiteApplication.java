package com.example.retailwebsite;

import com.example.retailwebsite.enums.ProductType;
import com.example.retailwebsite.enums.UserType;
import com.example.retailwebsite.model.Bill;
import com.example.retailwebsite.model.Product;
import com.example.retailwebsite.model.User;
import com.example.retailwebsite.service.impl.BillCalculatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RetailWebsiteApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RetailWebsiteApplication.class, args);
    }

    @Override
    public void run(String... args) {


        // Create a bill
        Bill bill = new Bill("1", getDummyProductsList());

        // Create a user
        User user1 = new User("1", UserType.EMPLOYEE, 1);
        User user2 = new User("2", UserType.AFFILIATE, 1);
        User user3 = new User("3", UserType.CUSTOMER, 2);
        User user4 = new User("4", UserType.CUSTOMER, 3);

        // Calculate the net payable amount
        BillCalculatorService billCalculatorService = new BillCalculatorService();
        calculateNetPayableAmount(billCalculatorService,bill, user1);
        calculateNetPayableAmount(billCalculatorService,bill, user2);
        calculateNetPayableAmount(billCalculatorService,bill, user3);
        calculateNetPayableAmount(billCalculatorService,bill, user4);

    }

    private void calculateNetPayableAmount(BillCalculatorService billCalculatorService, Bill bill, User user) {
        double netPayableAmount = billCalculatorService.calculateNetPayableAmount(bill, user);
        System.out.println("Net Payable Amount: $" + netPayableAmount);
    }

    private List<Product> getDummyProductsList() {

        Product p1 = new Product("1", ProductType.ELECTRONICS, 100);
        Product p2 = new Product("2", ProductType.GROCERIES, 200);
        Product p3 = new Product("3", ProductType.CLOTHING, 300);
        Product p4 = new Product("4", ProductType.FURNITURE, 500);

        return Arrays.asList(p1, p2, p3, p4);

    }
}
