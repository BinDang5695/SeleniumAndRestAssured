package test.ui.testdata;

import models.ui.Expenses;
import settings.helpers.FileHelper;

public class ExpensesData {

    public static Expenses getExpense() {
        return new Expenses(
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

    public static Expenses getUpdatedExpense() {
        return new Expenses(
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