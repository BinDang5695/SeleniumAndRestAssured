package ui.testcases;

import constants.CRM;
import constants.CRM.Menu;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import testdata.ui.Expenses;

@Epic("Regression Test")
@Feature("Expense")
public class ExpensesTest extends BaseTest {

    private final models.ui.Expenses expense = Expenses.getExpense();
    private final models.ui.Expenses updatedExpense = Expenses.getUpdatedExpense();

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Create, verify")
    @Story("Expense")
    @Description("Create Expense Successfully")
    @Test(priority = 1)
    public void EXPENSE_001_CreateExpenseSuccessfully() {
        basePage().clickByMenuText(Menu.EXPENSES);
        expensesPage().clickButtonRecordExpense();
        expensesPage().inputToAddNewExpense(expense);
        expensesPage().clickButtonSave();
        expensesPage().verifyCreatedExpense(expense);
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Update, verify")
    @Story("Expense")
    @Description("Update Expense Successfully")
    @Test(priority = 2)
    public void EXPENSE_002_UpdateExpenseSuccessfully() {
        basePage().clickByMenuText(Menu.EXPENSES);
        expensesPage().searchExpense(expense);
        expensesPage().hoverToExpense(expense);
        basePage().clickButtonEdit();
        expensesPage().inputToUpdateExpense(updatedExpense);
        expensesPage().clickButtonSave();
        expensesPage().verifyUpdatedExpense(updatedExpense);
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Delete, verify")
    @Story("Expense")
    @Description("Delete Expense Successfully")
    @Test(priority = 3)
    public void EXPENSE_003_DeleteExpenseSuccessfully() {
        basePage().clickByMenuText(Menu.EXPENSES);
        expensesPage().searchExpense(updatedExpense);
        expensesPage().hoverToExpense(expense);
        basePage().deleteRecordAfterHover();
        expensesPage().verifyAlertDeletedExpense();
        expensesPage().searchExpense(updatedExpense);
        basePage().verifyNoItems(CRM.Message.NO_ENTRIES_FOUND);
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Verify")
    @Story("Expense")
    @Description("Verify Expense Tooltip When Creating Invoice")
    @Test(priority = 4)
    public void EXPENSE_004_VerifyExpenseTooltipInInvoice() {
        basePage().clickMenuSales();
        basePage().clickByMenuName(Menu.INVOICES);
        expensesPage().clickButtonCreateNewInvoice();
        expensesPage().hoverToTooltip();
        expensesPage().verifyExpenseTooltipContent();
    }
}