package test.ui.crmpages;

import constants.CRM.*;
import models.ui.Expenses;
import org.openqa.selenium.By;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import test.ui.common.BasePage;

public class ExpensesPage extends BasePage {

    private By buttonRecordExpense = By.xpath("//a[normalize-space()='Record Expense']");
    private By buttonAttachReceipt = By.xpath("//span[normalize-space()='Attach Receipt']");
    private By inputName = By.xpath("//input[@id='expense_name']");
    private By inputNote = By.xpath("//textarea[@id='note']");
    private By dropdownExpenseCategory = By.xpath("//div[contains(text(),'Nothing selected')]");
    private By inputExpenseCategory = By.xpath("//input[@aria-controls='bs-select-2']");
    private By getCategory(String category) {
        return By.xpath("//span[normalize-space()='" + category + "']");
    }
    private By inputExpenseDate = By.xpath("//input[@id='date']");
    private By inputAmount = By.xpath("//input[@id='amount']");
    private By dropdownPaymentMode = By.xpath("//button[@data-id='paymentmode']");
    private By inputPaymentMode = By.xpath("//input[@aria-controls='bs-select-6']");
    private By getPaymentMode(String paymentMode) {
        return By.xpath("//a[normalize-space()='" + paymentMode + "']");
    }
    private By inputReference = By.xpath("//input[@id='reference_no']");
    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
    private By getRepeatEvery (String repeatEvery) {
        return By.xpath("//span[normalize-space()='" + repeatEvery + "']");
    }
    private By checkboxInfinity = By.xpath("//label[normalize-space()='Infinity']");
    private By inputTotalCycles = By.xpath("//input[@id='cycles']");
    private By buttonSave = By.xpath("//div[@class='btn-bottom-toolbar text-right']//button[@type='submit'][normalize-space()='Save']");
    private By buttonCreateNewInvoice = By.xpath("//a[normalize-space()='Create New Invoice']");
    private By toggleItem = By.xpath("//i[@data-title='New lines are not supported for item description. Use the item long description instead.']");
    private By expenseName = By.xpath("//h4[@id='expenseName']");
    private By getexpenseNote (String expenseNote) {
        return By.xpath("//div[normalize-space()='" + expenseNote + "']");
    }
    private By expenseCategory = By.xpath("//h3[@id='expenseCategory']");
    private By getexpenseDate (String expenseDate) {
        return By.xpath("//span[normalize-space()='" + expenseDate + "']");
    }
    private By getexpenseAmount (String expenseAmount) {
        return By.xpath("//span[contains(normalize-space(),'" + expenseAmount + "')]");
    }

    private By getexpensePaymentMode (String expensePaymentMode) {
        return By.xpath("//span[contains(normalize-space(),'" + expensePaymentMode + "')]");
    }

    private By getexpenseRef (String expenseRef) {
        return By.xpath("//span[normalize-space()='" + expenseRef + "']");
    }

    private By getexpenseRepeat (String expenseRepeat) {
        return By.xpath("//b[normalize-space()='" + expenseRepeat + "']");
    }

    private By getexpenseCyclesRemaining (String expenseCyclesRemaining) {
        return By.xpath("//b[normalize-space()='" + expenseCyclesRemaining + "']");
    }

    private By getAttachedReceipt (String attachedReceipt) {
        return By.xpath("//a[normalize-space()='" + attachedReceipt + "']");
    }
    private By buttonEditExpense = By.xpath("//i[contains(@class,'pen')]");
    private By getUpdatedExpenseAmount (String updatedExpenseAmount) {
        return By.xpath("//span[contains(normalize-space(),'" + updatedExpenseAmount + "')]");
    }
    private By buttonDeleteExpense = By.xpath("//a[contains(@class,'delete')]//i[contains(@class,'remove')]");
    private By inputSearchExpenses = By.xpath("//input[@aria-controls='expenses']");

    public void clickButtonRecordExpense() {
        WebUI.clickElement(buttonRecordExpense);
    }

    public void addNewExpense(Expenses expenses) {
        WebUI.uploadFileWithRobotClass(buttonAttachReceipt, expenses.getFileName());
        WebUI.setTextElement(inputName, expenses.getName());
        WebUI.setTextElement(inputNote, expenses.getNote());
        WebUI.clickElement(dropdownExpenseCategory);
        WebUI.setTextElement(inputExpenseCategory, expenses.getCategory());
        WebUI.clickElement(getCategory(expenses.getCategory()));
        WebUI.setTextElement(inputExpenseDate, expenses.getDate());
        WebUI.setTextElement(inputAmount, expenses.getAmount());
        WebUI.clickElement(dropdownPaymentMode);
        WebUI.setTextElement(inputPaymentMode, expenses.getPaymentMode());
        WebUI.clickElement(getPaymentMode(expenses.getPaymentMode()));
        WebUI.setTextElement(inputReference, expenses.getReference());
        WebUI.clickElement(dropdownRepeatEvery);
        WebUI.clickElement(getRepeatEvery(expenses.getRepeatEvery()));
        WebUI.clickElement(checkboxInfinity);
        WebUI.setTextElement(inputTotalCycles, expenses.getCycles());
        WebUI.clickElement(buttonSave);
    }

    public void verifyCreatedExpense(Expenses expenses) {
        AssertHelper.assertEquals(WebUI.getTextElement(expenseName), expenses.getName(), "Expense Name does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpenseNote(expenses.getNote())), expenses.getNote(), "Expense Note does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(expenseCategory), expenses.getCategory(), "Expense Category does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpenseDate(expenses.getDate())), expenses.getDate(), "Expense Date does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpenseAmount(expenses.getVerifyAmount())), expenses.getVerifyAmount(), "Expense Amount does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpensePaymentMode(expenses.getVerifyPaymentMode())), expenses.getVerifyPaymentMode(), "Expense Payment Mode does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpenseRef(expenses.getReference())), expenses.getReference(), "Expense Ref does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpenseRepeat(expenses.getRepeatDate())), expenses.getRepeatDate(), "Expense Repeat does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getexpenseCyclesRemaining(expenses.getCycles())), expenses.getCycles(), "Expense Cycles Remaining does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getAttachedReceipt(expenses.getVerifyReceipt())), expenses.getVerifyReceipt(), "Expense attached Receipt does not match");
    }

    public void clickButtonEditExpense() {
        WebUI.clickElement(buttonEditExpense);
    }

    public void updateExpense(Expenses getUpdatedExpense) {
        WebUI.setTextElement(inputName, getUpdatedExpense.getName());
        WebUI.setTextElement(inputNote, getUpdatedExpense.getNote());
        WebUI.setTextElement(inputAmount, getUpdatedExpense.getAmount());
        WebUI.clickElement(buttonSave);
    }

    public void verifyUpdatedExpense(Expenses getUpdatedExpense) {
        AssertHelper.assertEquals(getSuccessMessage(), Message.UPDATED_EXPENSE,"Expense update failed");
        AssertHelper.assertEquals(WebUI.getTextElement(expenseName), getUpdatedExpense.getName(), "Expense Name after updated does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(getUpdatedExpenseAmount(getUpdatedExpense.getVerifyAmount())), getUpdatedExpense.getVerifyAmount(), "Expense Amount after updated does not match");
    }

    public void clickButtonDeleteExpense() {
        WebUI.clickElement(buttonDeleteExpense);
    }

    public void verifyAlertDeletedExpense() {
        AssertHelper.assertEquals(getSuccessMessage(), Message.DELETED_EXPENSE,"Expense delete failed");
        clickButtonX();
    }

    public void verifyDeletedExpense(Expenses getUpdatedExpense) {
        WebUI.waitForPageRefresh(inputSearchExpenses);
        WebUI.setTextElement(inputSearchExpenses, getUpdatedExpense.getCategory());
        verifyNoItems(Message.NO_ENTRIES_FOUND);
    }

    public void clickButtonCreateNewInvoice() {
        WebUI.clickElement(buttonCreateNewInvoice);
    }

    public void verifyExpenseTooltipContent() {
        WebUI.moveToElement(toggleItem);
        verifyTooltipContent("New lines are not supported for item description. Use the item long description instead.");
    }
}
