package ui.pages;

import constants.CRM.*;
import models.ui.Lead;
import org.openqa.selenium.By;
import settings.helpers.AssertHelper;
import settings.helpers.TableHelper;
import settings.keywords.WebUI;
import settings.utils.LogUtils;
import ui.common.BasePage;

public class LeadsPage extends BasePage {

    private By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By inputStatus = By.xpath("//input[@aria-controls='bs-select-5']");
    private By getStatus (String status) {
        return By.xpath("//span[@class='text'][normalize-space()='" + status + "']");
    }
    private By dropdownSource = By.xpath("//button[@data-id='source']");
    private By inputSource = By.xpath("//input[@aria-controls='bs-select-6']");
    private By getSource (String source) {
        return By.xpath("//span[normalize-space()='" + source + "']");
    }
    private By dropdownTags = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By getTags (String tags) {
        return By.xpath("//li[contains(@class,'menu')]//div[normalize-space()='" + tags + "']");
    }
    private By inputName = By.xpath("//div[@class='col-md-6']//input[@id='name']");
    private By checkboxContactedToday = By.xpath("//label[normalize-space()='Contacted Today']");
    private By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    private By buttonSave = By.xpath("//button[@id='lead-form-submit']");
    private By dropdownPagination = By.xpath("//select[@name='leads_length']");
    private By getLeadsLength (int leadsLength) {
        return By.xpath("//option[@value='" + leadsLength + "']");
    }
    private By inputSearchLead = By.xpath("//input[@aria-controls='leads']");
    private By contentLeads_info1To10 = By.xpath("//div[@id='leads_info' and contains(., 'Showing 1 to 10 of 11 entries')]");
    private By contentLeads_info11To11 = By.xpath("//div[@id='leads_info' and contains(., 'Showing 11 to 11 of 11 entries')]");
    private By getPageNumber (int pageNumber) {
        return By.xpath("//a[normalize-space()='" + pageNumber + "']");
    }

    public void clickButtonNewLead() {
        WebUI.clickElement(buttonNewLead);
    }

    public void addNewLead(Lead getLead) {
        WebUI.clickElement(dropdownStatus);
        WebUI.setTextElement(inputStatus, getLead.getStatus());
        WebUI.clickElement(getStatus(getLead.getStatus()));
        WebUI.clickElement(dropdownSource);
        WebUI.setTextElement(inputSource, getLead.getSource());
        WebUI.clickElement(getSource(getLead.getSource()));
        WebUI.clickElement(dropdownTags);
        WebUI.setTextElement(dropdownTags, getLead.getTags());
        WebUI.clickElement(getTags(getLead.getTags()));
        WebUI.setTextElement(inputName, getLead.getName());
        WebUI.clickElement(checkboxContactedToday);
        WebUI.setTextElement(inputDateContacted, getLead.getContactedToday());
        WebUI.clickElement(buttonSave);
        WebUI.waitForPageRefresh(buttonNewLead);
    }

    public void createMultipleLeads(Lead leadData, int totalLead) {

        for (int i = 1; i <= totalLead; i++) {

            Lead lead = new Lead(
                    leadData.getName() + " " + i,
                    String.format("bin%d.dangvan@nashtechglobal.com", i),
                    leadData.getStatus(),
                    leadData.getSource(),
                    leadData.getTags(),
                    leadData.getContactedToday()
            );

            LogUtils.info("Creating Lead: " + lead.getName());

            clickByMenuName(Menu.LEADS);
            clickButtonNewLead();
            addNewLead(lead);
        }
    }

    public void searchAndCheckDataInTable(Lead getLead, int column, String data, String columnName) {
        WebUI.clickElement(dropdownPagination);
        WebUI.clickElement(getLeadsLength(10));
        WebUI.setTextElement(inputSearchLead, getLead.getName());
        WebUI.waitForElementVisible(contentLeads_info1To10);
        TableHelper.checkDataInTableByColumn_Contains(column, data, columnName);
        WebUI.clickElement(getPageNumber(2));
        WebUI.waitForElementVisible(contentLeads_info11To11);
        TableHelper.checkDataInTableByColumn_Contains(column, data, columnName);
    }

    public void searchAndSelectAllLeads() {
        WebUI.clickElement(getPageNumber(1));
        WebUI.clickElement(getLeadsLength(25));
        clickSelectAllAndEnsureChecked();
    }

    public void verifyDeletedLeads(Lead getLead) {
        AssertHelper.assertEquals(getSuccessMessage(), "Total leads deleted: 11","The alert Success does not match.");
        clickButtonX();
        WebUI.setTextElement(inputSearchLead, getLead.getName());
        verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }
}
