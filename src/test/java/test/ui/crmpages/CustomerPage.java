package test.ui.crmpages;

import constants.CRM.*;
import settings.drivers.DriverManager;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import org.openqa.selenium.By;
import models.ui.Customer;
import settings.utils.LogUtils;
import test.ui.common.BasePage;

public class CustomerPage extends BasePage {

    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputSearchCustomer = By.xpath("//input[@aria-controls='clients']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVATNumber = By.xpath("//input[@id='vat']");
    private By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropDownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By searchGroups = By.xpath("//input[@aria-controls='bs-select-1']");
    private By getGroups(String groups) {
        return By.xpath("//a[normalize-space()='" + groups + "']");
    }
    private By currencyDropdown = By.xpath("//button[@aria-owns='bs-select-2']");
    private By getCurrency(String currency) {
        return By.xpath("//small[contains(text(),'" + currency + "')]");
    }
    private By defaultLanguageDropdown = By.xpath("//button[@aria-owns='bs-select-3']");
    private By getDefaultLanguage(String defaultLanguage) {
        return By.xpath("//span[normalize-space()='" + defaultLanguage + "']");
    }
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By countryDropdown = By.xpath("//button[@aria-owns='bs-select-4']");
    private By searchCountry = By.xpath("//input[@aria-controls='bs-select-4']");
    private By getCountry(String country) {
        return By.xpath("//span[normalize-space()='" + country + "']");
    }
    private By buttonSave = By.xpath("//button[contains(@class,'only-save')]");
    private By getDataInTable(String companyName) {
        return By.xpath("//a[normalize-space()='" + companyName + "']");
    }
    private By totalCustomer = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    public void clickbuttonAddNewCustomer() {
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void addNewCustomer(Customer customer) {
        WebUI.setTextElement(inputCompany, customer.getCompany());
        WebUI.setTextElement(inputVATNumber, customer.getVatNumber());
        WebUI.setTextElement(inputPhoneNumber, customer.getPhoneNumber());
        WebUI.setTextElement(inputWebsite, customer.getWebsite());
        WebUI.clickElement(dropDownGroups);
        WebUI.setTextElement(searchGroups, customer.getGroup());
        WebUI.clickElement(getGroups(customer.getGroup()));
        WebUI.clickElement(dropDownGroups);
        WebUI.clickElement(currencyDropdown);
        WebUI.clickElement(getCurrency(customer.getCurrencySymbol()));
        WebUI.clickElement(defaultLanguageDropdown);
        WebUI.clickElement(getDefaultLanguage(customer.getLanguage()));
        WebUI.setTextElement(inputAddress, customer.getAddress());
        WebUI.setTextElement(inputCity, customer.getCity());
        WebUI.setTextElement(inputState, customer.getState());
        WebUI.setTextElement(inputZipCode, customer.getZipCode());
        WebUI.clickElement(countryDropdown);
        WebUI.setTextElement(searchCountry, customer.getCountry());
        WebUI.clickElement(getCountry(customer.getCountry()));
        WebUI.clickElement(buttonSave);
    }

    public void verifyCustomerAdded(Customer customer) {
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputCompany, "value"), customer.getCompany(), "Company name not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputVATNumber, "value"), customer.getVatNumber(), "VAT number not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputPhoneNumber, "value"), customer.getPhoneNumber(), "PhoneNumber not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputWebsite, "value"), customer.getWebsite(), "Website not matched");
        AssertHelper.assertEquals(WebUI.getTextElement(dropDownGroups), customer.getGroup(), "Groups not matched");
        AssertHelper.assertEquals(WebUI.getTextElement(currencyDropdown), customer.getCurrency(), "Currency not matched");
        AssertHelper.assertEquals(WebUI.getTextElement(defaultLanguageDropdown), customer.getLanguage(), "Default Language not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputAddress, "value"), customer.getAddress(), "Address not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputCity, "value"), customer.getCity(), "City name not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputState, "value"), customer.getState(), "State name not matched");
        AssertHelper.assertEquals(WebUI.getAttributeElement(inputZipCode, "value"), customer.getZipCode(), "Zip code not matched");
        AssertHelper.assertEquals(WebUI.getTextElement(countryDropdown), customer.getCountry(), "Country name not matched");
    }

    public int getTotalCustomers() {
        String totalString = DriverManager.getDriver().findElement(totalCustomer).getText();
        LogUtils.info("getCustomerTotal: " + totalString);
        return Integer.parseInt(totalString);
    }

    public void searchCustomer(Customer customer) {
        WebUI.setTextElement(inputSearchCustomer, customer.getCompany());
        AssertHelper.assertTrue(WebUI.checkElementDisplayed(getDataInTable(customer.getCompany())), "Customer not found");
    }

    public void moveToCompanyName(Customer customer) {
        WebUI.moveToElement(getDataInTable(customer.getCompany()));
    }

    public void verifyCustomerDeleted(Customer customer) {
        WebUI.setTextElement(inputSearchCustomer, customer.getCompany());
        verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }

}
