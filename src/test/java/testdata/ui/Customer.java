package testdata.ui;

public class Customer {

    public static models.ui.Customer getCustomer() {
        return new models.ui.Customer(
                "Bin Customer",
                "EUR",
                "€"
        );
    }
}