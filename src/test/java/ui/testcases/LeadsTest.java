package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import testdata.ui.Lead;

@Epic("Regression Test")
@Feature("Lead")
public class LeadsTest extends BaseTest {

    private final models.ui.Lead lead = Lead.getLead();

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Create, verify")
    @Story("Leads")
    @Description("Create Multiple Leads Successfully")
    @Test(priority = 1)
    public void LEAD_001_CreateMultipleLeadsSuccessfully() {
        basePage().clickByMenuName(Menu.LEADS);
        leadsPage().createMultipleLeads(lead, 3);
        leadsPage().searchLead(lead);
        leadsPage().verifyLeadLengthInTable(3, lead.getName(), "Name");
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Delete, verify")
    @Story("Leads")
    @Description("Delete Multiple Leads Successfully")
    @Test(priority = 2)
    public void LEAD_002_DeleteMultipleLeadsSuccessfully() {
        basePage().clickByMenuName(Menu.LEADS);
        basePage().clickSelectAllAndEnsureChecked();
        basePage().deleteRecordAfterSelectCheckbox();
        leadsPage().verifyAlertDeletedLeads();
        leadsPage().searchLead(lead);
        leadsPage().verifyNoItems(Message.NO_ENTRIES_FOUND);

    }
}