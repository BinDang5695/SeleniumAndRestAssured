package ui.testcases;

import constants.CRM.Menu;
import models.ui.Contact;
import models.ui.Customer;
import ui.common.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.testdata.ContactData;
import ui.testdata.CustomerData;

import static settings.keywords.WebUI.acceptAlert;

public class CustomerTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Customer")
    @Story("Customer")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-4")
    @Issue("CRM-4")
    @Description("Add new Customer, verify and delete Customer")
    @Test(priority = 0)
    public void manageCustomer() {
        Customer customer = CustomerData.getCustomer();
        Contact contact = ContactData.getContact();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickByMenuName(Menu.CUSTOMERS);
        int beforeTotal = customerPage().getTotalCustomers();
        customerPage().clickbuttonAddNewCustomer();
        customerPage().addNewCustomer(customer);
        customerPage().verifyCustomerAdded(customer);
        clickByLinkText(Menu.CONTACTS);
        contactsPage().clickButtonNewContact();
        contactsPage().addNewContact(contact);
        contactsPage().verifyCreatedContact();
        contactsPage().clickCreatedContact(contact);
        contactsPage().verifyCreatedContact(contact);
        contactsPage().clickButtonClosePopup();
        clickByMenuText(Menu.CUSTOMERS);
        customerPage().searchCustomer(customer);
        int afterTotal = customerPage().getTotalCustomers();
        Assert.assertEquals(afterTotal, beforeTotal + 1, "Total customers should be increased by 1 after adding a new customer.");
        customerPage().moveToCompanyName(customer);
        clickButtonDelete();
        acceptAlert();
        clickButtonX();
        customerPage().verifyCustomerDeleted(customer);
    }

}
