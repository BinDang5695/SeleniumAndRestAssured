package test.ui.auth;

import org.openqa.selenium.By;
import settings.drivers.DriverManager;
import settings.helpers.PropertiesHelper;
import test.ui.crmpages.LoginPage;

public class AuthManager {

    private static final String FILE = ".auth/admin.json";

    public static void ensureLogin() {

        boolean restored = StorageStateManager.restore(
                PropertiesHelper.getValue("URL"),
                FILE
        );

        if (!restored || !isLoggedIn()) {
            loginAndSave();
        }
    }

    private static void loginAndSave() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM();

        //waitDashboard();

        StorageStateManager.save(FILE);
    }

    private static void waitDashboard() {

        DriverManager.getDriver().findElement(
                By.xpath("//span[normalize-space()='Dashboard']")
        );
    }

    private static boolean isLoggedIn() {

        return DriverManager.getDriver()
                .findElements(By.xpath("//span[normalize-space()='Dashboard']"))
                .size() > 0;
    }
}