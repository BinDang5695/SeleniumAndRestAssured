package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import testdata.ui.Contract;
import testdata.ui.Customer;

public class ContractsTest extends BaseTest {

    private final models.ui.Customer customer = Customer.getCustomer();
    private final models.ui.Contract contract = Contract.getContract();
    private final models.ui.Contract updatedContract = Contract.getUpdatedContract();

    @Epic("Regression Test")
    @Feature("Create, verify")
    @Story("Contract")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create Contract Successfully")
    @Test(priority = 1)
    public void CONTRACT_001_CreateContractSuccessfully() {
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().clickButtonAddNewCustomer();
        customerPage().inputToAddNewCustomer(customer);
        customerPage().clickButtonSave();
        basePage().clickByMenuName(Menu.CONTRACTS);
        contractsPage().clickButtonNewContract();
        contractsPage().inputToAddNewContract(contract);
        contractsPage().clickButtonSave();
        contractsPage().verifyCreatedContract(contract);
    }

    @Epic("Regression Test")
    @Feature("Update, verify")
    @Story("Contract")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Update Contract Successfully")
    @Test(priority = 2)
    public void CONTRACT_002_UpdateContractSuccessfully() {
        basePage().clickByMenuName(Menu.CONTRACTS);
        contractsPage().searchOnContract(contract.getSubject());
        contractsPage().hoverToContract(contract.getSubject());
        basePage().clickButtonEdit();
        contractsPage().inputToUpdateContract(updatedContract);
        contractsPage().clickButtonSave();
        contractsPage().verifyUpdatedContract(updatedContract);
    }

    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("Contract")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete Contract Successfully")
    @Test(priority = 3)
    public void CONTRACT_003_DeleteContractSuccessfully() {
        basePage().clickByMenuName(Menu.CONTRACTS);
        contractsPage().searchOnContract(updatedContract.getSubject());
        contractsPage().hoverToContract(updatedContract.getSubject());
        basePage().deleteRecordAfterHover();
        contractsPage().searchOnContract(updatedContract.getSubject());
        contractsPage().verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().searchCustomer(customer.getCompany());
        customerPage().moveToCompanyName(customer.getCompany());
        basePage().deleteRecordAfterHover();

    }
}