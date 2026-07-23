package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import models.ui.ExportFileType;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import ui.dataproviders.DataProviderFactory;
import testdata.ui.Customer;
import testdata.ui.Proposal;

public class ProposalsTest extends BaseTest {

    private final models.ui.Proposal proposal = Proposal.getProposal();
    private final models.ui.Customer customer = Customer.getCustomer();

    @Epic("Regression Test")
    @Feature("Add New Proposal")
    @Story("Proposal")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add new Proposal, verify, export and delete Proposal with 3 file types")
    @Test(priority = 1, dataProvider = "exportTypes", dataProviderClass = DataProviderFactory.class)
    public void verifyCreateProposal(ExportFileType type) {
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().clickButtonAddNewCustomer();
        customerPage().inputToAddNewCustomer(customer);
        customerPage().clickButtonSave();
        basePage().clickMenuSales();
        basePage().clickByMenuName(Menu.PROPOSALS);
        proposalsPage().clickButtonNewProposal();
        proposalsPage().inputToAddNewProposal(proposal);
        proposalsPage().moveToButtonSaveAddNewProposal();
        proposalsPage().clickButtonSaveAddNewProposal();
        proposalsPage().moveToIconToggleFullView();
        proposalsPage().verifyContentToggle();
        proposalsPage().clickButtonToogleTableRight();
        proposalsPage().searchCreatedProposal(proposal);
        proposalsPage().exportAndVerifyContentFile(type, proposal);
        proposalsPage().waitProposal(proposal);
        proposalsPage().clickCreatedProposal(proposal);
        basePage().deleteRecordAfterSelectDropdown();
        proposalsPage().searchCreatedProposal(proposal);
        basePage().verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().searchCustomer(customer.getCompany());
        customerPage().moveToCompanyName(customer.getCompany());
        basePage().deleteRecordAfterHover();
    }
}
