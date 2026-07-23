package ui.testcases;

import constants.CRM.*;
import ui.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import testdata.ui.Customer;
import testdata.ui.Project;

public class ProjectTest extends BaseTest {

    private final models.ui.Project project = Project.getProject();
    private final models.ui.Customer customer = Customer.getCustomer();

    @Epic("Regression")
    @Feature("Create, verify")
    @Story("Project")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can create new project")
    @Test(priority = 1)
    public void verifyCreateProject() {
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().clickButtonAddNewCustomer();
        customerPage().inputToAddNewCustomer(customer);
        customerPage().clickButtonSave();
        basePage().clickByMenuName(Menu.PROJECTS);
        projectPage().verifyNavigateToProjectPage();
        projectPage().clickButtonAddNewProject();
        projectPage().submitDataForNewCustomer(project);
        projectPage().clickButtonSaveProject();
        projectPage().verifyProjectCreated(project);
    }
    @Epic("Regression")
    @Feature("Delete, verify")
    @Story("Project")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can delete project")
    @Test(priority = 1)
    public void verifyDeleteProject() {
        basePage().clickByMenuName(Menu.PROJECTS);
        projectPage().searchCustomer(project);
        projectPage().moveToProjectName(project);
        basePage().deleteRecordAfterHover();
        projectPage().searchCustomer(project);
        basePage().verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
        basePage().clickByMenuName(Menu.CUSTOMERS);
        customerPage().searchCustomer(customer.getCompany());
        customerPage().moveToCompanyName(customer.getCompany());
        basePage().deleteRecordAfterHover();
    }
}