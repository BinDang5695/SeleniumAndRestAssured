package ui.pages;

import constants.CRM.*;
import models.ui.KnowledgeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.drivers.DriverManager;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import ui.common.BasePage;

import java.time.Duration;
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

    public void inputToAddNewArticle(KnowledgeBase getArticle) {
        WebUI.setTextElement(inputSubject, getArticle.getSubject());
        WebUI.clickElement(dropdownGroup);
        WebUI.setTextElement(searchGroup, getArticle.getGroup());
        WebUI.clickElement(getGroup(getArticle.getGroup()));
        WebUI.clickElement(checkboxInternalArticle);
        WebUI.clickElement(checkboxDisabled);
        enterDescription(getArticle.getDescription());
    }

    public void clickButtonSave() {
        WebUI.clickElement(buttonSave);
    }

    public void verifyArticleDetail(KnowledgeBase getArticle) {
        AssertHelper.assertEquals(WebUI.getTextElement(getNameArticle(getArticle.getSubject())), getArticle.getSubject(), "Article subject does not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getDescriptionArticle(getArticle.getDescription())), getArticle.getDescription(), "Article description does not match.");
    }

    public void voteArticle() {
        WebUI.clickElement(buttonYes);
    }

    public void waitForRealTime() {
        WebUI.waitForPageRefresh(buttonYes);
    }

    public void verifyFeedbackMessage(String expectedMessage) {
        AssertHelper.assertEquals(WebUI.getTextElement(messageNotification), expectedMessage, "Feedback message does not match.");
    }

    public void moveToCreatedArticle(KnowledgeBase getArticle) {
        WebUI.moveToElement(getCreatedArticle(getArticle.getSubject()));
    }

}
