package ui.testdata;

import models.ui.Customer;

public class CustomerData {

    public static Customer getCustomer() {
        return new Customer(
                "Nashtech Company",
                "123456789",
                "0123456789",
                "https://nashtech.com.vn",
                "VIP",
                "EUR",
                "€",
                "Vietnamese",
                "123 Street, Hanoi",
                "Hanoi",
                "Hoan Kiem",
                "100000",
                "Vietnam"
        );
    }
}