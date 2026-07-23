package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import testdata.ui.Item;

@Epic("Regression Test")
@Feature("Item")
public class ItemsTest extends BaseTest {

    private final models.ui.Item item = Item.getItem();

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Import, create, verify")
    @Story("Item")
    @Description("Import Item Successfully")
    @Test(priority = 1)
    public void ITEM_001_ImportItemSuccessfully() {
        basePage().clickMenuSales();
        basePage().clickByMenuName(Menu.ITEMS);
        itemsPage().clickButtonImportItems();
        itemsPage().importCSVFile(item);
        itemsPage().clickToImportCSVFile();
        basePage().clickMenuSales();
        basePage().clickByMenuName(Menu.ITEMS);
        itemsPage().searchItem(item);
        itemsPage().verifyItems(item);
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Delete, verify")
    @Story("Item")
    @Description("Delete Item Successfully")
    @Test(priority = 2)
    public void ITEM_002_DeleteItemSuccessfully() {
        basePage().clickMenuSales();
        basePage().clickByMenuName(Menu.ITEMS);
        itemsPage().searchItem(item);
        itemsPage().moveToTableDescription(item);
        basePage().deleteRecordAfterHover();
        itemsPage().searchItem(item);
        basePage().verifyNoItems(Message.NO_MATCHING_RECORDS_FOUND);
    }

}