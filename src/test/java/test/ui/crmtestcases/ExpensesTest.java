package test.ui.crmtestcases;

import constants.CRM.*;
import io.qameta.allure.*;
import models.ui.Expenses;
import org.testng.annotations.Test;
import test.ui.common.BaseTest;
import test.ui.testdata.ExpensesData;
import static settings.keywords.WebUI.*;

public class ExpensesTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Expense")
    @Story("Expense")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-9")
    @Issue("CRM-9")
    @Description("Add new Expense, verify and delete Expense")
    @Test(priority = 0)
    public void manageExpense() {
        Expenses expenses = ExpensesData.getExpense();
        Expenses updatedExpenses = ExpensesData.getUpdatedExpense();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickByMenuText(Menu.EXPENSES);
        expensesPage().clickButtonRecordExpense();
        expensesPage().addNewExpense(expenses);
        expensesPage().verifyCreatedExpense(expenses);
        expensesPage().clickButtonEditExpense();
        expensesPage().updateExpense(updatedExpenses);
        expensesPage().verifyUpdatedExpense(updatedExpenses);
        expensesPage().clickButtonDeleteExpense();
        acceptAlert();
        expensesPage().verifyAlertDeletedExpense();
        expensesPage().verifyDeletedExpense(updatedExpenses);
        clickMenuSales();
        clickByMenuName(Menu.INVOICES);
        expensesPage().clickButtonCreateNewInvoice();
        expensesPage().verifyExpenseTooltipContent();
    }
}
