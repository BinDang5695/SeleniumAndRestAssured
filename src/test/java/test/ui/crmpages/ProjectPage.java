package test.ui.crmpages;

import constants.CRM.*;
import models.ui.Project;
import settings.drivers.DriverManager;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.ui.common.BasePage;

public class ProjectPage extends BasePage {

    private By titleProjectPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By inputSearchProject = By.xpath("//input[@aria-controls='projects']");
    private By getProjectName (String projectName) {
        return By.xpath("//a[normalize-space()='" + projectName + "']");
    }
    private By buttonNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By inputCustomer = By.xpath("//button[@data-id='clientid']");
    private By searchCustomer = By.xpath("//input[@placeholder='Type to search...']");
    private By getCustomerName (String customerName) {
        return By.xpath("//span[normalize-space()='" + customerName + "']");
    }
    private By checkBoxCalculate = By.xpath("//label[normalize-space()='Calculate progress through tasks']");
    private By saveProject = By.xpath("//button[normalize-space()='Save']");
    private By getProjectNameCustomer(String projectName, String customerName) {
        return By.xpath("//button[@title='" + projectName + " - " + customerName + "']");
    }
    private By projectProgress = By.xpath("//p[contains(@class,'project-info')]");
    private By customer = By.xpath("//dt[normalize-space()='Customer']");
    private By status = By.xpath("//dt[normalize-space()='Status']");
    private By statusProject = By.xpath("//dd[normalize-space()='In Progress']");

    public void verifyNavigateToProjectPage()
    {
        AssertHelper.assertEquals(WebUI.getTextElement(titleProjectPage), "Projects Summary", "The ProjectPage title not match.");
    }

    public void clickButtonAddNewCustomer()
    {
        WebUI.clickElement(buttonNewProject);
    }

    public void moveSliderToMiddle()
    {
        WebDriver driver = DriverManager.getDriver();
        WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        WebElement sliderBar = slider.findElement(By.xpath("./.."));
        int width = sliderBar.getSize().width;
        int xOffset = (int) (width * 0.5);
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(xOffset, 0)
                .release()
                .perform();
    }

    public void submitDataForNewCustomer(Project project)
    {
        WebUI.setTextElement(inputProjectName, project.getName());
        WebUI.clickElement(inputCustomer);
        WebUI.setTextElement(searchCustomer, project.getCustomer());
        WebUI.clickElement(getCustomerName(project.getCustomer()));
        WebUI.clickElement(checkBoxCalculate);
        moveSliderToMiddle();
        WebUI.clickElement(saveProject);
    }

    public void verifyProjectCreated(Project project)
    {
        AssertHelper.assertEquals(getSuccessMessage(), Message.CREATED_PROJECT,"Project creation failed");
        AssertHelper.assertEquals(WebUI.getTextElement(getProjectNameCustomer(project.getName(), project.getCustomer())), project.getVerifyProjectNameCustomer(), "The project customer header page not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(projectProgress), project.getVerifyProjectProgress(), "The project progress not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(customer), "Customer", "The customer title not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getProjectName(project.getCustomer())), project.getCustomer(), "The customer name not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(status), "Status", "The status title not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(statusProject), "In Progress", "The statusProject title not match.");
    }

    public void searchAndCheckCustomerInTable(Project project)
    {
        WebUI.setTextElement(inputSearchProject, project.getName());
        AssertHelper.assertEquals(WebUI.getTextElement(getProjectName(project.getName())), project.getName(), "The customer name in table not match");
    }

    public void moveToProjectName(Project project)
    {
        WebUI.moveToElement(getProjectName(project.getName()));
    }

    public void searchProjectInTable(Project project)
    {
        WebUI.setTextElement(inputSearchProject, project.getCustomer());
    }

    public void verifyNoDataAfterDeletedProject()
    {
        verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }

}
