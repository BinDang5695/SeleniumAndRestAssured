package test.ui.crmpages;

import models.ui.ExportFileType;
import models.ui.Proposal;
import org.openqa.selenium.By;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import settings.utils.LogUtils;
import test.ui.common.BasePage;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProposalsPage extends BasePage {

    private By buttonNewProposals = By.xpath("//a[normalize-space()='New Proposal']");
    private By inputSubject = By.xpath("//input[@id='subject']");
    private By dropdownRelated = By.xpath("//button[@data-id='rel_type']");
    private By getRelated (String related) {
        return By.xpath("//a[@role='option']//span[normalize-space()='" + related + "']");
    }
    private By dropdownCustomer = By.xpath("//div[contains(text(),'Select and begin typing')]");
    private By inputCustomer = By.xpath("//input[@placeholder='Type to search...']");
    private By getCustomer (String customer) {
        return By.xpath("//span[normalize-space()='" + customer + "']");
    }
    private By inputDate = By.xpath("//input[@id='date']");
    private By getDay (String day) {
        return By.xpath("//div[normalize-space()='" + day + "']");
    }
    private By toogleAllowComments = By.xpath("//label[@for='allow_comments']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By buttonAdd = By.xpath("//div[@class='input-group-btn']");
    private By inputDescription = By.xpath("//input[@id='description']");
    private By inputRate = By.xpath("//input[@id='rate']");
    private By buttonSaveAddNewItem = By.xpath("//button[@type='submit']");
    private By radioHours = By.xpath("//label[normalize-space()='Hours']");
    private By buttonSelect = By.xpath("//button[@class='btn pull-right btn-primary']");
    private By buttonSaveAddNewProposal = By.xpath("//button[@type='button'][normalize-space()='Save']");
    private By iconToggleFullView = By.xpath("//li[@data-title='Toggle full view']");
    private By buttonToogleTableRight = By.xpath("//i[@class='fa fa-angle-double-right']");
    private By inputSearchProposals = By.xpath("//input[@aria-controls='proposals']");
    private By contentProposals_info = By.xpath("//div[@id='proposals_info' and contains(., 'Showing 1 to 1 of 1 entries')]");
    private By getCreatedProposal (String createdProposal) {
        return By.xpath("//td/a[normalize-space()='" + createdProposal + "']");
    }

    //Compare file PDF with data on UI table
    private By tableProposal = By.xpath("//tr[1]//td[1]//a[contains(@href,'list_proposals')]");
    private By getCaptureSubject (String captureSubject) {
        return By.xpath("//tr[1]//td[2]//a[normalize-space()='" + captureSubject + "']");
    }
    private By getCaptureCustomer (String captureCustomer) {
        return By.xpath("//a[contains(text(),'" + captureCustomer + "')]");
    }
    private By getCaptureTotal (String captureTotal) {
        return By.xpath("//td[contains(text(),'" + captureTotal + "')]");
    }
    private By getCaptureDate (String captureDate) {
        return By.xpath("//td[normalize-space()='" + captureDate + "']");
    }
    private By getCaptureOpenTill (String captureOpenTill) {
        return By.xpath("//td[normalize-space()='" + captureOpenTill + "']");
    }
    private By tableCreated = By.xpath("//td[@class='sorting_1']");
    private By tableStatus = By.xpath("//td//span[contains(@class,'proposal-status')]");

    public Map<String, String> captureUITableData(Proposal proposal) {

        Map<String, String> uiData = new LinkedHashMap<>();

        uiData.put("Proposal#", WebUI.getTextElement(tableProposal));
        uiData.put("Subject", WebUI.getTextElement(getCaptureSubject(proposal.getSubject())));
        uiData.put("To", WebUI.getTextElement(getCaptureCustomer(proposal.getCustomer())));
        uiData.put("Total", WebUI.getTextElement(getCaptureTotal(proposal.getTotal())));
        uiData.put("Date", WebUI.getTextElement(getCaptureDate(proposal.getDate())));
        uiData.put("Open Till", WebUI.getTextElement(getCaptureOpenTill(proposal.getOpenTill())));
        uiData.put("Project", "");
        uiData.put("Tags", "");
        uiData.put("Created", WebUI.getTextElement(tableCreated));
        uiData.put("Status", WebUI.getTextElement(tableStatus));
        LogUtils.info("📋 UI Data:");
        uiData.forEach((key, value) ->
                LogUtils.info(key + " : " + value));
        return uiData;
    }

    public void exportAndVerifyContentFile(
            ExportFileType type,
            Proposal proposal){

        Map<String,String> uiData = captureUITableData(proposal);

        String fileName = switch(type){

            case PDF -> "Proposals.pdf";
            case EXCEL -> "Proposals.xlsx";
            case CSV -> "Proposals.csv";
        };

        super.exportAndVerifyContentFile(type, fileName, uiData);
    }

    public void clickButtonNewProposal() {
        WebUI.clickElement(buttonNewProposals);
    }

    public void addNewProposal(Proposal proposal) {
        WebUI.setTextElement(inputSubject, proposal.getSubject());
        WebUI.clickElement(dropdownRelated);
        WebUI.clickElement(getRelated(proposal.getRelated()));
        WebUI.clickElement(dropdownCustomer);
        WebUI.setTextElement(inputCustomer, proposal.getCustomer());
        WebUI.clickElement(getCustomer(proposal.getCustomer()));
        WebUI.setTextElement(inputDate, proposal.getDate());
        WebUI.clickElement(getDay(proposal.getDay()));
        WebUI.clickElement(toogleAllowComments);
        WebUI.setTextElement(inputEmail, proposal.getEmail());
        WebUI.clickElement(buttonAdd);
        WebUI.setTextElement(inputDescription, proposal.getDescription());
        WebUI.setTextElement(inputRate, proposal.getRate());
        WebUI.clickElement(buttonSaveAddNewItem);
        WebUI.clickElement(radioHours);
        WebUI.scrollToBottom();
        WebUI.clickElement(buttonSelect);
        WebUI.scrollIntoViewIfNeeded(buttonSaveAddNewProposal);
        WebUI.clickElement(buttonSaveAddNewProposal);
        clickButtonX();
    }

    public void verifyContentToggle() {
        WebUI.moveToElement(iconToggleFullView);
        AssertHelper.assertEquals(WebUI.getAttributeElement(iconToggleFullView, "data-title"), "Toggle full view", "Tooltip content incorrect");
    }

    public void searchCreatedProposal(Proposal proposal) {
        WebUI.clickElement(buttonToogleTableRight);
        WebUI.setTextElement(inputSearchProposals, proposal.getSubject());
        WebUI.waitForElementVisible(contentProposals_info);
    }

    public void waitProposal(Proposal proposal) {
        WebUI.waitForPageRefresh(getCreatedProposal(proposal.getSubject()));
    }

}
