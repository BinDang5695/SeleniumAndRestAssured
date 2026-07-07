package test.ui.crmtestcases;

import constants.CRM.*;
import models.ui.Task;
import test.ui.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import test.ui.testdata.TaskData;

public class TaskTest extends BaseTest {

    @Epic("Regression")
    @Feature("DMS")
    @Story("Task")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://crm.anhtester.com/admin/tasks")
    @Issue("https://nashtech-global.atlassian.net/")
    @Test(description = "Verify can create, update & delete Task")
    public void verifyTask() {
        Task task = TaskData.getTask();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickByMenuName(Menu.TASKS);
        taskPage().verifyNavigateToTasksPage();
        taskPage().clickButtonSwitchToKanBan();
        taskPage().verifyNavigateToKanbanPage();
        taskPage().clickButtonAddNewTask();
        taskPage().verifyAddNewTaskPopUp();
        taskPage().submitDataForNewTask(task);
        taskPage().verifyNewTaskAfterCreated(task);
        taskPage().markCompletedAndRefreshPage();
        taskPage().verifyCompleteTasksAfterRefreshed();
        taskPage().editTask(task);
        taskPage().searchAndVerifyAfterSearch(task);
        taskPage().dragAndDrop();
        taskPage().verifyTotalTasksAfterDragDrop();
        taskPage().searchAndDeleteTask(task);
        taskPage().searchAfterDeleted(task);
        taskPage().verifyNoDataAfterDeleted();
        clickButtonX();
    }
}