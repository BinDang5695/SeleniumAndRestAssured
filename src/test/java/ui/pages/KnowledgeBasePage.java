package ui.pages;

import constants.CRM.*;
import models.ui.KnowledgeBase;
import org.openqa.selenium.By;
import settings.drivers.DriverManager;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import ui.common.BasePage;

import java.util.Set;

public class KnowledgeBasePage extends BasePage {

    private By buttonNewArticle = By.xpath("//a[normalize-space()='New Article']");
    private By inputSubject = By.xpath("//input[@id='subject']");
    private By dropdownGroup = By.xpath("//button[@data-id='articlegroup']");
    private By searchGroup = By.xpath("//input[@aria-label='Search']");
    private By getGroup (String group) {
        return By.xpath("//span[normalize-space()='" + group + "']");
    }
    private By checkboxInternalArticle = By.xpath("//label[normalize-space()='Internal Article']");
    private By checkboxDisabled = By.xpath("//div[@class='panel-body']//label[@for='disabled'][normalize-space()='Disabled']");
    private By iframeDescription = By.id("description_ifr");
    private By editorBody = By.id("tinymce");
    private By buttonSave = By.xpath("//div[@class='panel-footer text-right']//button[@type='submit'][normalize-space()='Save']");
    private By getCreatedArticle (String createdArticle) {
        return By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'" + createdArticle + "')]");
    }
    private By getNameArticle (String nameArticle) {
        return By.xpath("//h4[normalize-space()='" + nameArticle + "']");
    }
    private By getDescriptionArticle (String descriptionArticle) {
        return By.xpath("//p[normalize-space()='" + descriptionArticle + "']");
    }
    private By buttonYes = By.xpath("//button[normalize-space()='Yes']");
    private By messageNotification = By.xpath("//div[contains(@class,'answer_response')]");

    public void clickButtonNewArticle() {
        WebUI.clickElement(buttonNewArticle);
    }

    public void enterDescription(String content) {
        WebUI.switchToIframe(iframeDescription);
        WebUI.clickElement(editorBody);
        WebUI.setTextElement(editorBody, content);
        WebUI.switchToDefaultContent();
    }

    public void addNewArticle(KnowledgeBase getArticle) {
        WebUI.setTextElement(inputSubject, getArticle.getSubject());
        WebUI.clickElement(dropdownGroup);
        WebUI.setTextElement(searchGroup, getArticle.getGroup());
        WebUI.clickElement(getGroup(getArticle.getGroup()));
        WebUI.clickElement(checkboxInternalArticle);
        WebUI.clickElement(checkboxDisabled);
        enterDescription(getArticle.getDescription());
        WebUI.clickElement(buttonSave);
    }

    public void switchBetweenTabTest(KnowledgeBase getArticle) {
        String tab1 = DriverManager.getDriver().getWindowHandle();
        WebUI.moveToElement(getCreatedArticle(getArticle.getSubject()));
        clickButtonView();

        Set<String> allTabs = DriverManager.getDriver().getWindowHandles();
        String tab2 = null;

        for (String handle : allTabs) {
            if (!handle.equals(tab1)) {
                tab2 = handle;
                break;
            }
        }

        if (tab2 != null) {
            DriverManager.getDriver().switchTo().window(tab2);

            AssertHelper.assertEquals(WebUI.getTextElement(getNameArticle(getArticle.getSubject())), getArticle.getSubject(), "The project progress not match.");
            AssertHelper.assertEquals(WebUI.getTextElement(getDescriptionArticle(getArticle.getDescription())), getArticle.getDescription(), "The description Article does not match.");
            WebUI.clickElement(buttonYes);
            AssertHelper.assertEquals(WebUI.getTextElement(messageNotification), Message.THANKS_FOR_YOUR_FEEDBACK, "The 1st message Notification does not match.");
            WebUI.waitForPageRefresh(buttonYes);
            WebUI.clickElement(buttonYes);
            AssertHelper.assertEquals(WebUI.getTextElement(messageNotification), Message.YOU_CAN_VOTE_ONCE_IN_24_HOURS, "The 2nd message Notification does not match.");
        }

        DriverManager.getDriver().switchTo().window(tab1);

    }

    public void moveToCreatedArticle(KnowledgeBase getArticle) {
        WebUI.moveToElement(getCreatedArticle(getArticle.getSubject()));
    }

}
