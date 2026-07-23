package ui.pages;

import models.ui.Item;
import org.openqa.selenium.By;
import settings.helpers.AssertHelper;
import settings.keywords.WebUI;
import ui.common.BasePage;

public class ItemsPage extends BasePage {

    private By buttonImportItems = By.xpath("//a[normalize-space()='Import Items']");
    private By buttonChooseFile = By.xpath("//input[@id='file_csv']");
    private By buttonImport = By.xpath("//button[normalize-space()='Import']");
    private By inputSearchItems = By.xpath("//input[@aria-controls='DataTables_Table_1']");
    private By getTableDescription(String tableDescription) {
        return By.xpath("//a[normalize-space()='" + tableDescription + "']");
    }
    private By getTableLongDescription(String tableLongDescription) {
        return By.xpath("//td[normalize-space()='" + tableLongDescription + "']");
    }
    private By getTableRate(String tableRate) {
        return By.xpath("//td[normalize-space()='" + tableRate + "']");
    }
    private By getTableTax1(String tableTax1) {
        return By.xpath("//td[5]//span[normalize-space()='" + tableTax1 + "']");
    }
    private By getTableTax2(String tableTax2) {
        return By.xpath("//td[6]//span[normalize-space()='" + tableTax2 + "']");
    }
    private By getTableUnit(String tableUnit) {
        return By.xpath("//td[normalize-space()='" + tableUnit + "']");
    }

    public void clickButtonImportItems() {
        WebUI.clickElement(buttonImportItems);
    }

    public void importCSVFile(Item getItem) {
        WebUI.sendKeysUploadFile(buttonChooseFile, getItem.getFile());
    }

    public void clickToImportCSVFile() {
        WebUI.clickElement(buttonImport);
    }

    public void searchItem(Item getItem) {
        WebUI.setTextElement(inputSearchItems, getItem.getLongDescription());
    }

    public void verifyItems(Item getItem) {
        AssertHelper.assertEquals(WebUI.getTextElement(getTableDescription(getItem.getDescription())), getItem.getDescription(), "The Description does not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getTableLongDescription(getItem.getLongDescription())), getItem.getLongDescription(), "The Long description does not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getTableRate(getItem.getRate())), getItem.getRate(), "The Rate does not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getTableTax1(getItem.getTax1())), getItem.getTax1(), "The Tax 1 does not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getTableTax2(getItem.getTax2())), getItem.getTax2(), "The Tax 2 does not match.");
        AssertHelper.assertEquals(WebUI.getTextElement(getTableUnit(getItem.getUnit())), getItem.getUnit(), "The Unit does not match.");
    }

    public void moveToTableDescription(Item getItem) {
        WebUI.moveToElement(getTableDescription(getItem.getDescription()));
    }
}
