package ui.testcases;

import constants.CRM;
import constants.CRM.Menu;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import testdata.ui.Contact;
import testdata.ui.Customer;

public class CustomerTest extends BaseTest {

    private final models.ui.Customer customer = Customer.getCustomer();
    private final models.ui.Contact contact = Contact.getContact();

    @Epic("Regression Test")
    @Feature("Create, verify")
    @Story("Customer")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create Customer Successfully")
    @Test(priority = 1)
    public void CUSTOMER_001_CreateCustomerSuccessfully() {
        basePage().clickByMenuName(Menu.CUSTOMERS);
        int beforeTotal = customerPage().getTotalCustomers();
        customerPage().clickButtonAddNewCustomer();
        customerPage().inputToAddNewCustomer(customer);
        customerPage().clickButtonSave();
        customerPage().verifyCustomerAdded(customer);
        basePage().clickByMenuName(Menu.CUSTOMERS);
        int afterTotal = customerPage().getTotalCustomers();
        Assert.assertEquals(afterTotal, beforeTotal + 1, "Total customers should increase by 1.");
    }

    @Epic("Regression Test")
    @Feature("Create, verify")
    @Story("Contact")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create Contact Successfully")
    @Test(priority = 2)
    public void CONTACT_001_CreateContactSuccessfully() {
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().searchCustomer(customer.getCompany());
        customerPage().moveToCompanyName(customer.getCompany());
        basePage().clickButtonView();
        basePage().clickByLinkText(Menu.CONTACTS);
        contactsPage().clickButtonNewContact();
        contactsPage().inputToAddNewContact(contact);
        contactsPage().clickButtonSave();
        contactsPage().verifyAlertCreatedContact();
        contactsPage().clickCreatedContact(contact);
        contactsPage().verifyCreatedContact(contact);
    }

    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("Customer")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete Customer Successfully")
    @Test(priority = 3)
    public void CUSTOMER_002_DeleteCustomerSuccessfully() {
        basePage().clickByMenuName(Menu.CUSTOMERS);
        int beforeTotal = customerPage().getTotalCustomers();
        customerPage().searchCustomer(customer.getCompany());
        customerPage().moveToCompanyName(customer.getCompany());
        basePage().deleteRecordAfterHover();
        customerPage().searchCustomer(customer.getCompany());
        basePage().verifyNoItems(CRM.Message.NO_MATCHING_RECORDS_FOUND);
        int afterTotal = customerPage().getTotalCustomers();
        Assert.assertEquals(afterTotal, beforeTotal - 1, "Total customers should decrease by 1.");
    }
}