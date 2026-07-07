package ui.pages;

import settings.helpers.AssertHelper;
import settings.helpers.PropertiesHelper;
import settings.keywords.WebUI;
import settings.reports.AllureManager;
import org.openqa.selenium.By;
import ui.common.BasePage;

public class LoginPage extends BasePage {

        private By inputEmail = By.xpath("//input[@id='email']");
        private By inputPassword = By.xpath("//input[@id='password']");
        private By checkboxRememberme = By.xpath("//label[normalize-space()='Remember me']");
        private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
        private By alertErrorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");

        public DashboardPage loginCRM(String email, String password)
        {
            WebUI.openURL(PropertiesHelper.getValue("URL"));
            WebUI.setTextElement(inputEmail, email);
            WebUI.setTextElement(inputPassword, password);
            WebUI.clickElement(buttonLogin);
            return new DashboardPage();
        }

        public DashboardPage loginCRM()
        {
            WebUI.openURL(PropertiesHelper.getValue("URL"));
            WebUI.setTextElement(inputEmail, PropertiesHelper.getValue("EMAIL"));
            WebUI.setTextElement(inputPassword, PropertiesHelper.getValue("PASSWORD"));
            WebUI.clickElement(checkboxRememberme);
            WebUI.clickElement(buttonLogin);
            return new DashboardPage();
        }

        public void verifyLoginSuccess()
        {
            waitMenuDashboard();
            AssertHelper.assertNotContains(WebUI.getCurrentURL(), "authentication", "Still in Login page, but expected to be in Dashboard page");
        }

        public void verifyLoginFail(String text)
        {
            AssertHelper.assertContains(WebUI.getCurrentURL(), "authentication", "Login success, but expected to fail");
            AssertHelper.assertTrue(WebUI.checkElementDisplayed(alertErrorMessage), "Login success, but expected to fail");
            AssertHelper.assertEquals(WebUI.getTextElement(alertErrorMessage), text, "Error message is not as expected");
            AllureManager.saveTextLog("==> Login failed with error message: " + text);
        }

}
