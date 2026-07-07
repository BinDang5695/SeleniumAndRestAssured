package ui.testcases;

import io.qameta.allure.*;
import models.ui.Lead;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import ui.testdata.LeadData;
import static settings.keywords.WebUI.*;

public class LeadsTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Lead")
    @Story("Lead")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-10")
    @Issue("CRM-10")
    @Description("Add new Lead, verify and delete Lead")
    @Test(priority = 0)
    public void manageLead() {
        Lead lead = LeadData.getLead();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        leadsPage().createMultipleLeads(lead, 11);
        leadsPage().searchAndCheckDataInTable(lead,3, lead.getName(), "Name");
        leadsPage().searchAndSelectAllLeads();
        clickButtonBulkActions();
        clickCheckboxMassDelete();
        clickButtonConfirm();
        acceptAlert();
        leadsPage().verifyDeletedLeads(lead);
    }
}
