package ui.auth;

import org.openqa.selenium.By;
import settings.drivers.DriverManager;
import settings.helpers.PropertiesHelper;
import ui.pages.LoginPage;

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

        StorageStateManager.save(FILE);
    }

    private static boolean isLoggedIn() {

        return DriverManager.getDriver()
                .findElements(By.xpath("//span[normalize-space()='Dashboard']"))
                .size() > 0;
    }
}