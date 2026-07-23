package ui.testcases;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.common.BaseTestNotLogin;

public class LoginTestByExcelFile extends BaseTestNotLogin {

    @Epic("Regression Test")
    @Feature("Login")
    @Story("Login")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-4")
    @Issue("CRM-4")
    @Description("Login with valid credentials from Excel file")
    @Test(priority = 1)
    public void loginSuccess()
    {
        excelHelper().setExcelFile("src/test/resources/filetest/CRM_LoginTest2.xlsx", "LoginDataProvider");
        loginPage().loginCRM(excelHelper().getCellData("Email", 1),
                excelHelper().getCellData("Password", 1));
        loginPage().verifyLoginSuccess();
    }

    @Epic("Regression Test")
    @Feature("Login")
    @Story("Login")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-5")
    @Issue("CRM-5")
    @Description("Login with invalid credentials from Excel file")
    @Test(priority = 2)
    public void loginFailWithInvalidEmail()
    {
        excelHelper().setExcelFile("src/test/resources/filetest/CRM_LoginTest2.xlsx", "LoginDataProvider");
        loginPage().loginCRM(excelHelper().getCellData("Email", 2),
                excelHelper().getCellData("Password", 2));
        loginPage().verifyLoginFail("Invalid email or password");
    }

    @Epic("Regression Test")
    @Feature("Login")
    @Story("Login")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-6")
    @Issue("CRM-6")
    @Description("Login with invalid credentials from Excel file")
    @Test(priority = 3)
    public void loginFailWithInvalidPassword()
    {
        excelHelper().setExcelFile("src/test/resources/filetest/CRM_LoginTest2.xlsx", "LoginDataProvider");
        loginPage().loginCRM(excelHelper().getCellData("Email", 3),
                excelHelper().getCellData("Password", 3));
        loginPage().verifyLoginFail("Invalid email or password");
    }

    @Epic("Regression Test")
    @Feature("Login")
    @Story("Login")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-7")
    @Issue("CRM-7")
    @Description("Login with invalid credentials from Excel file")
    @Test(priority = 4)
    public void loginFailWithEmptyEmail()
    {
        excelHelper().setExcelFile("src/test/resources/filetest/CRM_LoginTest2.xlsx", "LoginDataProvider");
        loginPage().loginCRM(excelHelper().getCellData("Email", 4),
                excelHelper().getCellData("Password", 4));
        loginPage().verifyLoginFail("The Email Address field is required.");
    }

    @Epic("Regression Test")
    @Feature("Login")
    @Story("Login")
    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-8")
    @Issue("CRM-8")
    @Description("Login with invalid credentials from Excel file")
    @Test(priority = 5)
    public void loginFailWithEmptyPassword() {
        excelHelper().setExcelFile("src/test/resources/filetest/CRM_LoginTest2.xlsx", "LoginDataProvider");
        loginPage().loginCRM(excelHelper().getCellData("Email", 5),
                excelHelper().getCellData("Password", 5));
        loginPage().verifyLoginFail("The Password field is required.");
    }
}
