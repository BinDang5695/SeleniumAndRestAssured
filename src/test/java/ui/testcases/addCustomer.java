package ui.testcases;

import constants.CRM.Menu;
import ui.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.dataproviders.DataProviderFactory;
import ui.testdata.CustomerCase;

public class addCustomer extends BaseTest {

    @Test(dataProvider = "customerData", dataProviderClass = DataProviderFactory.class)
    public void manageCustomer(CustomerCase customerCase) {
        clickByMenuName(Menu.CUSTOMERS);

        customerPage().clickbuttonAddNewCustomer();

        customerPage().addNewCustomerDataDriven(customerCase.getData());

        if ("success".equals(customerCase.getExpectedType())) {

            customerPage().verifyCustomerAddedDataDriven(customerCase.getData());

            clickByMenuName(Menu.CUSTOMERS);

            customerPage().deleteCustomerIfExist(customerCase.getData());

        } else {

            customerPage().verifyCreateFail(customerCase.getExpectedMessage());

        }
    }
}
