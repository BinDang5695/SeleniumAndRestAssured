package test.ui.crmtestcases;

import constants.CRM.*;
import io.qameta.allure.*;
import models.ui.Item;
import org.testng.annotations.Test;
import test.ui.common.BaseTest;
import test.ui.testdata.ItemData;
import static settings.keywords.WebUI.*;

public class ItemsTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Item")
    @Story("Item")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-15")
    @Issue("CRM-15")
    @Description("Add new Item, verify and delete Item")
    @Test(priority = 0)
    public void manageItems() {
        Item item = ItemData.getItem();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickMenuSales();
        clickByMenuName(Menu.ITEMS);
        itemsPage().clickButtonImportItems();
        itemsPage().importCSVFile(item);
        itemsPage().clickToImportCSVFile();
        clickMenuSales();
        clickByMenuName(Menu.ITEMS);
        itemsPage().searchAndVerifyItems(item);
        itemsPage().moveToTableDescription(item);
        clickButtonDelete();
        acceptAlert();
        clickButtonX();
    }
}
