package test.ui.crmpages;

import constants.CRM.*;
import models.ui.Task;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import test.ui.common.BasePage;

public class TaskPage extends BasePage {

    private By titleTaskPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By switchToKanBan = By.xpath("//i[@class='fa-solid fa-grip-vertical']");
    private By switchToList = By.xpath("//i[@class='fa-solid fa-table-list']");
    private By completeTaskTotal = By.xpath("//div[@class='panel-heading'][contains(text(),'Complete')]");
    private By notStartedTaskTotal = By.xpath("//div[@class='panel-heading'][contains(text(),'Not Started')]");
    private By newTaskButton = By.xpath("//a[normalize-space()='New Task']");
    private By titleAddNewTaskPopUp = By.xpath("//h4[normalize-space()='Add new task']");
    private By inputStartDate = By.xpath("//input[@id='startdate']");
    private By titleSubject = By.xpath("//label[@for='name']");
    private By inputSubject = By.xpath("//input[@id='name']");
    private By saveTask = By.xpath("//button[normalize-space()='Save']");
    private By taskName = By.xpath("//h4[contains(@class,'modal-title ')]");
    private By taskStatus = By.xpath("//span[contains(@class,'trigger') and normalize-space()='In Progress']");
    private By markComplete = By.xpath("//i[@class='fa fa-check']");
    private By closePopUp = By.xpath("//div[@class='modal-header task-single-header']//button[@aria-label='Close']");
    private By searchOnKanBan = By.xpath("//input[@id='search']");
    private By nodataNotStarted = By.xpath("//ul[@data-col-status-id='1']//h4[contains(.,'No Tasks Found')]");
    private By nodataInprogress = By.xpath("//ul[@data-col-status-id='4']//h4[contains(.,'No Tasks Found')]");
    private By nodataTesting = By.xpath("//ul[@data-col-status-id='3']//h4[contains(.,'No Tasks Found')]");
    private By nodataAwaitingFeedback = By.xpath("//ul[@data-col-status-id='2']//h4[contains(.,'No Tasks Found')]");
    private By menu = By.xpath("//a[@class='trigger manual-popover mright5']");
    private By editOption = By.xpath("//div[@class='popover-content']//ul//li//a[@href='#'][normalize-space()='Edit']");
    private By getTaskName (String taskname) {
        return By.xpath("//span[normalize-space()='" + taskname + "']");
    }
    private By from = By.xpath("//ul[@data-task-status-id='5']");
    private By to = By.xpath("//ul[@data-col-status-id='1']//h4[contains(.,'No Tasks Found')]");
    private By searchOnList = By.xpath("//input[@aria-controls='tasks']");
    private By getEditedTask (String editedTask) {
        return By.xpath("//a[normalize-space()='" + editedTask + "']");
    }

    public void verifyNavigateToTasksPage()
    {
        AssertHelper.assertEquals(WebUI.getTextElement(titleTaskPage), "Tasks Summary", "The TaskPage title not match.");
    }

    public void clickButtonSwitchToKanBan()
    {
        WebUI.clickElement(switchToKanBan);
    }

    public void verifyNavigateToKanbanPage()
    {
        Assert.assertTrue(WebUI.checkElementExist(switchToList), "Not navigate to Kanban page yet.");
    }

    public void clickButtonAddNewTask()
    {
        WebUI.clickElement(newTaskButton);
    }

    public void verifyAddNewTaskPopUp()
    {
        AssertHelper.assertEquals(WebUI.getTextElement(titleAddNewTaskPopUp), "Add new task", "The AddNewTask title not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(titleSubject), "* Subject", "The Subject title not match.");
        Assert.assertFalse(WebUI.checkFieldIsToday(inputStartDate, "dd-MM-yyyy"), "The inputStartDate format NOT match.");
    }

    public void submitDataForNewTask(Task task)
    {
        WebUI.setTextElement(inputSubject, task.getSubject());
        WebUI.clickElement(saveTask);
    }

    public void verifyNewTaskAfterCreated(Task task)
    {
        AssertHelper.assertEquals(getSuccessMessage(), Message.CREATED_TASK,"Task create failed");
        AssertHelper.assertEquals(WebUI.getTextElement(taskName).replaceAll("\\s+", " ").trim(),
                task.getSubject_status(),
                "The taskName not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(taskStatus), "In Progress", "The taskStatus not match.");
    }

    public void markCompletedAndRefreshPage()
    {
        WebUI.clickElement(markComplete);
        WebUI.clickElement(closePopUp);
        WebUI.waitForPageRefresh(switchToList);
        WebUI.clickElement(switchToList);
        WebUI.clickElement(switchToKanBan);
    }

    public void verifyCompleteTasksAfterRefreshed()
    {
        AssertHelper.assertEquals(WebUI.getTextElement(completeTaskTotal), "Complete - 1 Tasks", "The completeTaskTotal title not match.");
    }

    public void editTask(Task task)
    {
        WebUI.clickElement(getTaskName(task.getSubject()));
        WebUI.clickElement(menu);
        WebUI.clickElement(editOption);
        WebUI.setTextElement(inputSubject, task.getUpdatedSubject());
        WebUI.clickElement(saveTask);
        WebUI.clickElement(closePopUp);
    }

    public void searchAndVerifyAfterSearch(Task task)
    {
        WebUI.setTextElement(searchOnKanBan, task.getUpdatedSubject());
        AssertHelper.assertEquals(WebUI.getTextElement(nodataNotStarted), "No Tasks Found", "The nodataNotStarted title not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(nodataInprogress), "No Tasks Found", "The nodataInprogress title not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(nodataTesting), "No Tasks Found", "The nodataTesting title not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(nodataAwaitingFeedback), "No Tasks Found", "The nodataAwaitingFeedback title not match.");
        WebUI.scrollHorizontally(from);
    }

    public void dragAndDrop()
    {
        WebUI.dragAndDrop(from, to);
    }

    public void verifyTotalTasksAfterDragDrop()
    {
        WebUI.waitForText(completeTaskTotal, "Complete - 0 Tasks");
        WebUI.waitForText(notStartedTaskTotal, "Not Started - 1 Tasks");
        AssertHelper.assertEquals(WebUI.getTextElement(completeTaskTotal), "Complete - 0 Tasks", "The completeTaskTotal not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(notStartedTaskTotal), "Not Started - 1 Tasks", "The notStartedTaskTotal not match.");
    }

    public void searchAndDeleteTask(Task task)
    {
        WebUI.clickElement(switchToList);
        WebUI.setTextElement(searchOnList, task.getUpdatedSubject());
        WebUI.scrollToTop();
        WebUI.moveToElement(getEditedTask(task.getUpdatedSubject()));
        clickButtonDelete();
        WebUI.acceptAlert();
    }

    public void searchAfterDeleted(Task task)
    {
        WebUI.setTextElement(searchOnList, task.getUpdatedSubject());
    }

    public void verifyNoDataAfterDeleted()
    {
        verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }

}
