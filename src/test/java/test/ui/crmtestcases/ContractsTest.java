package test.ui.crmtestcases;

import io.qameta.allure.*;
import models.ui.Contract;
import org.testng.annotations.Test;
import test.ui.common.BaseTest;
import test.ui.testdata.ContractData;
import constants.CRM.Menu;
import static settings.keywords.WebUI.*;

public class ContractsTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Contract")
    @Story("Contract")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-8")
    @Issue("CRM-8")
    @Description("Add new Contract, verify and delete Contract")
    @Test(priority = 0)
    public void manageContract() {
        Contract contract = ContractData.getContract();
        Contract updatedContract = ContractData.getUpdatedContract();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickByMenuName(Menu.CONTRACTS);
        contractsPage().clickButtonNewContract();
        contractsPage().addNewContract(contract);
        contractsPage().verifyCreatedContract(contract);
        contractsPage().updateContract(updatedContract);
        contractsPage().verifyUpdatedContract(updatedContract);
        clickDropdownMore();
        clickButtonDelete();
        acceptAlert();
        clickButtonX();
        clickByMenuName(Menu.CONTRACTS);
        contractsPage().verifyDeletedContract(updatedContract);
    }
}
