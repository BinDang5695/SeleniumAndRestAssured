package test.ui.crmpages;

import constants.CRM.*;
import models.ui.Contract;
import org.openqa.selenium.By;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import test.ui.common.BasePage;

public class ContractsPage extends BasePage {

    private By buttonNewContract = By.xpath("//a[normalize-space()='New Contract']");
    private By inputCustomer = By.xpath("//button[@data-id='clientid']");
    private By searchCustomer = By.xpath("//input[@placeholder='Type to search...']");
    private By selectCustomer(String customerName) {
        return By.xpath("//span[normalize-space()='" + customerName + "']");
    }
    private By inputSubject = By.xpath("//input[@id='subject']");
    private By inputContractValue = By.xpath("//input[@name='contract_value']");
    private By inputContractType = By.xpath("//button[@data-id='contract_type']");
    private By inputValueForContractType = By.xpath("//input[@aria-controls='bs-select-1']");
    private By selectContractType(String contractTypeName) {
        return By.xpath("//span[normalize-space()='" + contractTypeName + "']");
    }
    private By inputStartDate = By.xpath("//input[@id='datestart']");
    private By inputEndDate = By.xpath("//input[@id='dateend']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By buttonSave = By.xpath("//div[contains(@class,'btn')]//button[@type='submit']");
    private By selectedCustomer(String customerName) {
        return By.xpath("//div[contains(text(),'" + customerName + "')]");
    }
    private By selectedContractType(String contractTypeName) {
        return By.xpath("//div[contains(text(),'" + contractTypeName + "')]");
    }
    private By inputedDescription = By.xpath("//form[@id='contract-form']//textarea[@id='description']");
    private By searchContract = By.xpath("//input[@aria-controls='contracts']");

    public void clickButtonNewContract() {
        WebUI.clickElement(buttonNewContract);
    }

    public void addNewContract(Contract contract) {
        WebUI.clickElement(inputCustomer);
        WebUI.setTextElement(searchCustomer, contract.getCustomerName());
        WebUI.clickElement(selectCustomer(contract.getCustomerName()));
        WebUI.setTextElement(inputSubject, contract.getSubject());
        WebUI.setTextElement(inputContractValue, contract.getContractValue());
        WebUI.clickElement(inputContractType);
        WebUI.setTextElement(inputValueForContractType, contract.getContractType());
        WebUI.clickElement(selectContractType(contract.getContractType()));
        WebUI.setTextElement(inputStartDate, contract.getStartDate());
        WebUI.setTextElement(inputEndDate, contract.getEndDate());
        WebUI.setTextElement(inputDescription, contract.getDescription());
        WebUI.clickElement(buttonSave);
    }

    public void verifyCreatedContract(Contract contract) {
        AssertHelper.assertEquals(getSuccessMessage(), Message.CREATED_CONTRACT,"Contract creation failed");
        AssertHelper.assertEquals(WebUI.getTextElement(selectedCustomer(contract.getCustomerName())), contract.getCustomerName(), "Customer Name does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputSubject, "value"), contract.getSubject(), "Subject does not match");
        AssertHelper.assertEquals(Double.parseDouble(WebUI.getAttributeElement(inputContractValue, "value")), Double.parseDouble(contract.getContractValue()), "Contract Value does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(selectedContractType(contract.getContractType())), contract.getContractType(), "Selected Contract Type does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputStartDate, "value"), contract.getStartDate(), "Start Date does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputEndDate, "value"), contract.getEndDate(), "End Date does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputedDescription, "value"), contract.getDescription(), "Inputed Description after created does not match");
    }

    public void updateContract(Contract updatedContract) {
        WebUI.setTextElement(inputSubject, updatedContract.getSubject());
        WebUI.setTextElement(inputContractValue, updatedContract.getContractValue());
        WebUI.setTextElement(inputStartDate, updatedContract.getStartDate());
        WebUI.setTextElement(inputEndDate, updatedContract.getEndDate());
        WebUI.setTextElement(inputDescription, updatedContract.getDescription());
        WebUI.clickElement(buttonSave);
    }

    public void verifyUpdatedContract(Contract updatedContract) {
        AssertHelper.assertEquals(getSuccessMessage(), Message.UPDATED_CONTRACT,"Contract update failed");
        AssertHelper.assertEquals(WebUI.getTextElement(selectedCustomer(updatedContract.getCustomerName())), updatedContract.getCustomerName(), "Customer Name does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputSubject, "value"), updatedContract.getSubject(), "Subject does not match");
        AssertHelper.assertEquals(Double.parseDouble(WebUI.getAttributeElement(inputContractValue, "value")), Double.parseDouble(updatedContract.getContractValue()), "Contract Value does not match");
        AssertHelper.assertEquals(WebUI.getTextElement(selectedContractType(updatedContract.getContractType())), updatedContract.getContractType(), "Selected Contract Type does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputStartDate, "value"), updatedContract.getStartDate(), "Start Date does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputEndDate, "value"), updatedContract.getEndDate(), "End Date does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputDescription, "value"), updatedContract.getDescription(), "Description does not match");
    }

    public void verifyDeletedContract(Contract updatedContract) {
        WebUI.setTextElement(searchContract, updatedContract.getSubject());
        verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }

}
