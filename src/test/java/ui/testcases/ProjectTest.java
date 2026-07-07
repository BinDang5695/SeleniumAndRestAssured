package ui.testcases;

import constants.CRM.*;
import models.ui.Project;
import ui.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.testdata.ProjectData;
import static settings.keywords.WebUI.*;

public class ProjectTest extends BaseTest {

    @Epic("Regression")
    @Feature("DMS")
    @Story("Project")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://crm.anhtester.com/admin/projects")
    @Issue("https://nashtech-global.atlassian.net/")
    @Test(description = "Verify Project of Customer before and after delete")
    public void verifyProjectOfCustomer()
    {
        Project project = ProjectData.getProject();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickByMenuName(Menu.PROJECTS);
        projectPage().verifyNavigateToProjectPage();
        projectPage().clickButtonAddNewCustomer();
        projectPage().submitDataForNewCustomer(project);
        projectPage().verifyProjectCreated(project);
        clickByMenuName(Menu.PROJECTS);
        projectPage().searchAndCheckCustomerInTable(project);
        projectPage().moveToProjectName(project);
        clickButtonDelete();
        acceptAlert();
        clickButtonX();
        clickByMenuName(Menu.PROJECTS);
        projectPage().searchProjectInTable(project);
        projectPage().verifyNoDataAfterDeletedProject();
    }
}