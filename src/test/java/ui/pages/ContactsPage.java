package ui.pages;

import constants.CRM.Message;
import models.ui.Contact;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import org.openqa.selenium.By;
import ui.common.BasePage;

public class ContactsPage extends BasePage {

    private By buttonNewContact = By.xpath("//a[normalize-space()='New Contact']");
    private By fieldFirstName = By.xpath("//input[@id='firstname']");
    private By fieldLastName = By.xpath("//input[@id='lastname']");
    private By fieldEmail = By.xpath("//input[@id='email']");
    private By fieldPassword = By.xpath("//input[@name='password']");
    private By buttonChooseFile = By.xpath("//input[@type='file']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");
    private By getCreatedContact(String firstName, String lastName) {
        return By.xpath("//a[normalize-space()='" + firstName + " " + lastName + "']");
    }

    public void clickButtonNewContact() {
        WebUI.clickElement(buttonNewContact);
    }

    public void inputToAddNewContact(Contact contact) {
        WebUI.setTextElement(buttonChooseFile, contact.getFile());
        WebUI.setTextElement(fieldFirstName, contact.getFirstName());
        WebUI.setTextElement(fieldLastName, contact.getLastName());
        WebUI.setTextElement(fieldEmail, contact.getEmail());
        WebUI.setTextElement(fieldPassword, contact.getPassword());
    }

    public void clickButtonSave() {
        WebUI.clickElement(buttonSave);
    }

    public void verifyAlertCreatedContact() {
        AssertHelper.assertEquals(getSuccessMessage(), Message.CREATED_CONTACT,"Contact creation failed");
    }

    public void clickCreatedContact(Contact contact) {
        WebUI.clickElement(getCreatedContact(contact.getFirstName(), contact.getLastName()));
    }

    public void verifyCreatedContact(Contact contact) {
        AssertHelper.assertEquals(WebUI.getAttributeElement(fieldFirstName, "value"), contact.getFirstName(), "First name does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(fieldLastName, "value"), contact.getLastName(), "Last name does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(fieldEmail, "value"), contact.getEmail(), "Email does not match");
        AssertHelper.assertEquals(WebUI.getAttributeElement(fieldPassword, "value"), contact.getBlankPassword(), "Password does not match");
    }

}
