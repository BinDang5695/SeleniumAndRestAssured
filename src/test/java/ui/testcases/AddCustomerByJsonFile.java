package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import ui.common.BaseTest;
import org.testng.annotations.Test;
import ui.dataproviders.DataProviderFactory;
import models.ui.CustomerCase;

public class AddCustomerByJsonFile extends BaseTest {

    @Epic("Regression Test")
    @Feature("Create, verify, delete")
    @Story("Customer")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create, verify, delete customer with JSON file successfully")
    @Test(priority = 1, dataProvider = "customerData", dataProviderClass = DataProviderFactory.class)

    public void manageCustomer(CustomerCase customerCase) {
        clickByMenuName(Menu.CUSTOMERS);
        customerPage().clickButtonAddNewCustomer();
        customerPage().addNewCustomerDataDriven(customerCase.getData());
        customerPage().clickButtonSave();
        if ("success".equals(customerCase.getExpectedType())) {
            customerPage().verifyCustomerAddedDataDriven(customerCase.getData());
            clickByMenuName(Menu.CUSTOMERS);
            customerPage().searchCustomer(customerCase.getData().getCompany());
            customerPage().moveToCompanyName(customerCase.getData().getCompany());
            basePage().deleteRecordAfterHover();
            customerPage().searchCustomer(customerCase.getData().getCompany());
            verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
        } else {
            customerPage().verifyCreateFail(customerCase.getExpectedMessage());
        }
    }
}
