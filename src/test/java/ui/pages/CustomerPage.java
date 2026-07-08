package ui.pages;

import constants.CRM.*;
import org.testng.Assert;
import settings.drivers.DriverManager;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import org.openqa.selenium.By;
import models.ui.Customer;
import settings.utils.LogUtils;
import ui.common.BasePage;
import ui.testdata.CustomerDataDriven;

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
    private By errorMessage = By.xpath("//p[@id='company-error']");

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

    public void addNewCustomerDataDriven(CustomerDataDriven data) {

        if (data.getCompany() != null) {
            WebUI.setTextElement(inputCompany, data.getCompany());
        }

        if (data.getVatNumber() != null) {
            WebUI.setTextElement(inputVATNumber, data.getVatNumber());
        }

        if (data.getPhoneNumber() != null) {
            WebUI.setTextElement(inputPhoneNumber, data.getPhoneNumber());
        }

        if (data.getWebsite() != null) {
            WebUI.setTextElement(inputWebsite, data.getWebsite());
        }

        if (data.getGroup() != null) {
            WebUI.clickElement(dropDownGroups);
            WebUI.setTextElement(searchGroups, data.getGroup());
            WebUI.clickElement(getGroups(data.getGroup()));
            WebUI.clickElement(dropDownGroups);
        }

        if (data.getCurrencySymbol() != null) {
            WebUI.clickElement(currencyDropdown);
            WebUI.clickElement(getCurrency(data.getCurrencySymbol()));
        }

        if (data.getLanguage() != null) {
            WebUI.clickElement(defaultLanguageDropdown);
            WebUI.clickElement(getDefaultLanguage(data.getLanguage()));
        }

        if (data.getAddress() != null) {
            WebUI.setTextElement(inputAddress, data.getAddress());
        }

        if (data.getCity() != null) {
            WebUI.setTextElement(inputCity, data.getCity());
        }

        if (data.getState() != null) {
            WebUI.setTextElement(inputState, data.getState());
        }

        if (data.getZipCode() != null) {
            WebUI.setTextElement(inputZipCode, data.getZipCode());
        }

        if (data.getCountry() != null) {
            WebUI.clickElement(countryDropdown);
            WebUI.setTextElement(searchCountry, data.getCountry());
            WebUI.clickElement(getCountry(data.getCountry()));
        }

        WebUI.clickElement(buttonSave);
    }

    public void verifyCustomerAddedDataDriven(CustomerDataDriven data) {

        if (data.getCompany() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputCompany, "value"),
                    data.getCompany()
            );
        }

        if (data.getVatNumber() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputVATNumber, "value"),
                    data.getVatNumber()
            );
        }

        if (data.getPhoneNumber() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputPhoneNumber, "value"),
                    data.getPhoneNumber()
            );
        }

        if (data.getWebsite() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputWebsite, "value"),
                    data.getWebsite()
            );
        }

        if (data.getAddress() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputAddress, "value"),
                    data.getAddress()
            );
        }

        if (data.getCity() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputCity, "value"),
                    data.getCity()
            );
        }

        if (data.getState() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputState, "value"),
                    data.getState()
            );
        }

        if (data.getZipCode() != null) {
            Assert.assertEquals(
                    WebUI.getAttributeElement(inputZipCode, "value"),
                    data.getZipCode()
            );
        }
    }

    public void verifyCreateFail(String message) {

        WebUI.scrollToElement(errorMessage);
        WebUI.waitForElementVisible(errorMessage);

        Assert.assertTrue(
                WebUI.checkElementDisplayed(errorMessage),
                "Error message is not displayed"
        );

        Assert.assertEquals(
                WebUI.getTextElement(errorMessage),
                message
        );
    }

    public void deleteCustomerIfExist(CustomerDataDriven data) {

        if (data.getCompany() == null) {
            LogUtils.info("No company name provided, cannot delete");
            return;
        }

        WebUI.setTextElement(inputSearchCustomer, data.getCompany());

        WebUI.moveToElement(getDataInTable(data.getCompany()));

        clickButtonDelete();

        WebUI.acceptAlert();

        clickButtonX();

        WebUI.setTextElement(inputSearchCustomer, data.getCompany());
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
