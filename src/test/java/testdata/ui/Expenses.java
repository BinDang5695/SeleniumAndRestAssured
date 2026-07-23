package testdata.ui;

import settings.helpers.FileHelper;

public class Expenses {

    public static models.ui.Expenses getExpense() {
        return new models.ui.Expenses(
                "Bin Name",
                "Bin Note",
                "Bin Category",
                "18-11-2040",
                "1000",
                "Bank",
                "#1000",
                "Week",
                "25-11-2040",
                "10",
                FileHelper.getTestDataFile("UK.jpg"),
                "$1,000.00",
                "UK.jpg",
                "Paid Via Bank"
        );
    }

    public static models.ui.Expenses getUpdatedExpense() {
        return new models.ui.Expenses(
                "Bin Name Updated",
                "Bin Note Updated",
                "Bin Category",
                "18-11-2040",
                "2000",
                "Bank",
                "#1000",
                "Week",
                "25-11-2040",
                "10",
                FileHelper.getTestDataFile("UK.jpg"),
                "$2,000.00",
                "UK.jpg",
                "Paid Via Bank"
        );
    }
}