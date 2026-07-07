package test.ui.crmtestcases;

import constants.CRM.*;
import io.qameta.allure.*;
import models.ui.ExportFileType;
import models.ui.Proposal;
import org.testng.annotations.Test;
import test.ui.common.BaseTest;
import test.ui.dataproviders.DataProviderFactory;
import test.ui.testdata.ProposalData;
import static settings.keywords.WebUI.*;

public class ProposalsTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Proposal")
    @Story("Proposal")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-12")
    @Issue("CRM-12")
    @Description("Add new Proposal, verify and delete Proposal")
    @Test(priority = 0, dataProvider = "exportTypes", dataProviderClass = DataProviderFactory.class)
    public void manageProposalsPDFFile(ExportFileType type) {
        Proposal proposal = ProposalData.getProposal();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickMenuSales();
        clickByMenuName(Menu.PROPOSALS);
        proposalsPage().clickButtonNewProposal();
        proposalsPage().addNewProposal(proposal);
        proposalsPage().verifyContentToggle();
        proposalsPage().searchCreatedProposal(proposal);
        proposalsPage().exportAndVerifyContentFile(type, proposal);
        proposalsPage().waitProposal(proposal);
        clickDropdownMore();
        clickButtonDelete();
        acceptAlert();
        clickButtonX();
    }
}
