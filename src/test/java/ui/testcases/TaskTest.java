package ui.testcases;

import constants.CRM.*;
import ui.common.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import testdata.ui.Task;

public class TaskTest extends BaseTest {
    models.ui.Task task = Task.getTask();

    @Epic("Regression")
    @Feature("Verify")
    @Story("Task")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify navigate to Task Kanban page")
    @Test(priority = 1)
    public void verifyNavigateToTaskKanban() {
        basePage().clickByMenuName(Menu.TASKS);
        taskPage().verifyNavigateToTasksPage();
        taskPage().clickButtonSwitchToKanBan();
        taskPage().verifyNavigateToKanbanPage();
    }

    @Epic("Regression")
    @Feature("Create, verify")
    @Story("Task")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify create new task")
    @Test(priority = 2)
    public void verifyCreateTask() {
        basePage().clickByMenuName(Menu.TASKS);
        taskPage().clickButtonSwitchToKanBan();
        taskPage().clickButtonAddNewTask();
        taskPage().verifyAddNewTaskPopUp();
        taskPage().inputToSubmitDataForNewTask(task);
        taskPage().clickButtonSaveTask();
        taskPage().verifyNewTaskAfterCreated(task);
    }

    @Epic("Regression")
    @Feature("Verify")
    @Story("Task")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify complete task")
    @Test(priority = 3)
    public void verifyCompleteTask() {
        basePage().clickByMenuName(Menu.TASKS);
        taskPage().clickButtonSwitchToKanBan();
        taskPage().searchOnKanBan(task.getSubject());
        taskPage().moveToTask(task.getSubject());
        taskPage().clickTask(task);
        taskPage().markCompleted();
        taskPage().clickButtonSwitchToList();
        taskPage().clickButtonSwitchToKanBan();
        taskPage().verifyCompleteTask();
    }

    @Epic("Regression")
    @Feature("Update, verify")
    @Story("Task")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify edit task")
    @Test(priority = 4)
    public void verifyEditTask() {
        basePage().clickByMenuName(Menu.TASKS);
        taskPage().clickButtonSwitchToKanBan();
        taskPage().searchOnKanBan(task.getSubject());
        taskPage().moveToTask(task.getSubject());
        taskPage().clickTask(task);
        taskPage().selectMenu();
        taskPage().selectEditOption();
        taskPage().inputToUpdateTask(task);
        taskPage().clickButtonSaveTask();
        taskPage().verifyAfterUpdated();
    }

    @Epic("Regression")
    @Feature("Drag and drop, verify")
    @Story("Task")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify drag and drop task")
    @Test(priority = 5)
    public void verifyDragDropTask() {
        basePage().clickByMenuName(Menu.TASKS);
        taskPage().clickButtonSwitchToKanBan();
        taskPage().searchOnKanBan(task.getUpdatedSubject());
        taskPage().moveToTask(task.getUpdatedSubject());
        taskPage().dragAndDrop();
        taskPage().verifyTotalTasksAfterDragDrop();
    }

    @Epic("Regression")
    @Feature("Delete, verify")
    @Story("Task")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete task")
    @Test(priority = 6)
    public void verifyDeleteTask() {
        basePage().clickByMenuName(Menu.TASKS);
        taskPage().searchOnListTask(task);
        taskPage().moveToUpdatedTask(task.getUpdatedSubject());
        basePage().deleteRecordAfterHover();
        taskPage().searchOnListTask(task);
        taskPage().verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }
}