package ui.common;

import models.ui.ExportFileType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.drivers.DriverManager;
import settings.helpers.AssertHelper;
import settings.helpers.ExcelHelper;
import settings.helpers.FileHelper;
import settings.keywords.WebUI;
import org.openqa.selenium.By;
import settings.utils.LogUtils;
import ui.pages.*;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BasePage {

    private BasePage basePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;
    private ContactsPage contactsPage;
    private ProjectPage projectPage;
    private TaskPage taskPage;
    private ContractsPage contractsPage;
    private ExpensesPage expensesPage;
    private LeadsPage leadsPage;
    private KnowledgeBasePage knowledgeBase;
    private ProposalsPage proposalsPage;
    private ItemsPage itemsPage;
    private ExcelHelper excelHelper;

    private By menuSales = By.xpath("//span[@class='menu-text'][normalize-space()='Sales']");
    private By menuDashboard = By.xpath("//span[@class='menu-text'][normalize-space()='Dashboard']");
    private By alertSuccess = By.xpath("//span[@class='alert-title']");
    private By buttonView = By.xpath("//a[normalize-space()='View']");
    private By buttonDelete = By.xpath("//a[normalize-space()='Delete']");
    private By buttonX = By.xpath("//button[@data-dismiss='alert']");
    private By buttonClosePopup = By.xpath("//div[@class='modal-content data']//span[@aria-hidden='true'][normalize-space()='×']");
    private By noDataAfterDelete = By.xpath("//td[@class='dataTables_empty']");
    private By checkboxSelectAllLead = By.xpath("//div[@class='checkbox mass_select_all_wrap']");
    private By allBinLeadcheckbox = By.xpath("//div[@class='checkbox']");
    private By buttonBulkActions = By.xpath("//span[normalize-space()='Bulk Actions']");
    private By checkboxMassDelete = By.xpath("//label[normalize-space()='Mass Delete']");
    private By buttonConfirm = By.xpath("//a[normalize-space()='Confirm']");
    private By tooltipContent = By.cssSelector(".tooltip-inner");
    private By dropdownMore = By.xpath("//button[normalize-space()='More']");
    private By buttonExport = By.xpath("//span[normalize-space()='Export']");
    private By optionPDF = By.xpath("//a[normalize-space()='PDF']");
    private By optionExcel = By.xpath("//a[normalize-space()='Excel']");
    private By optionCSV = By.xpath("//a[normalize-space()='CSV']");
    private By optionPrint = By.xpath("//a[normalize-space()='Print']");
    private By buttonEdit = By.xpath("//div[@class='row-options']//a[contains(text(),'Edit')]");
    private By getPageNumber (int pageNumber) {
        return By.xpath("//a[normalize-space()='" + pageNumber + "']");
    }
    private By getByMenuText(String text) {
        return By.xpath("//span[@class='menu-text'][normalize-space()='" + text + "']");
    }
    private By getLinkByText(String text) {
        return By.xpath("//a[normalize-space()='" + text + "']");
    }

    private By getBySpanText(String text) {
        return By.xpath("//span[normalize-space()='" + text + "']");
    }

    public void clickByMenuText(String text) {
        WebUI.clickElement(getByMenuText(text));
    }

    public void clickByLinkText(String text) {
        WebUI.clickElement(getLinkByText(text));
    }

    public void clickByMenuName(String text) {
        WebUI.clickElement(getBySpanText(text));
    }

    public BasePage basePage() {
        if (basePage == null) {
            basePage = new BasePage();
        }
        return basePage;
    }

    public ExcelHelper excelHelper() {
        if (excelHelper == null) {
            excelHelper = new ExcelHelper();
        }
        return excelHelper;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public CustomerPage customerPage() {
        if (customerPage == null) {
            customerPage = new CustomerPage();
        }
        return customerPage;
    }

    public ContactsPage contactsPage() {
        if (contactsPage == null) {
            contactsPage = new ContactsPage();
        }
        return contactsPage;
    }

    public ProjectPage projectPage() {
        if (projectPage == null) {
            projectPage = new ProjectPage();
        }
        return projectPage;
    }

    public TaskPage taskPage () {
        if (taskPage == null) {
            taskPage = new TaskPage();
        }
        return taskPage;
    }

    public ContractsPage contractsPage () {
        if (contractsPage == null) {
            contractsPage = new ContractsPage();
        }
        return contractsPage;
    }

    public ExpensesPage expensesPage () {
        if (expensesPage == null) {
            expensesPage = new ExpensesPage();
        }
        return expensesPage;
    }

    public LeadsPage leadsPage () {
        if (leadsPage == null) {
            leadsPage = new LeadsPage();
        }
        return leadsPage;
    }

    public KnowledgeBasePage knowledgeBase () {
        if (knowledgeBase == null) {
            knowledgeBase = new KnowledgeBasePage();
        }
        return knowledgeBase;
    }

    public ProposalsPage proposalsPage () {
        if (proposalsPage == null) {
            proposalsPage = new ProposalsPage();
        }
        return proposalsPage;
    }

    public ItemsPage itemsPage () {
        if (itemsPage == null) {
            itemsPage = new ItemsPage();
        }
        return itemsPage;
    }

    public void clickMenuSales() {
        WebUI.clickElement(menuSales);
    }

    public void clickButtonX() {
        WebUI.clickElement(buttonX);
    }

    public void clickButtonClosePopup() {
        WebUI.clickElement(buttonClosePopup);
    }

    public void clickButtonDelete() {
        WebUI.clickElement(buttonDelete);
    }

    public void clickButtonView() {
        WebUI.clickElement(buttonView);
    }

    public void clickDropdownMore() {
        WebUI.moveToElement(dropdownMore);
        WebUI.clickElement(dropdownMore);
    }

    public void verifyNoItems(String expectedMessage) {
        AssertHelper.assertEquals(WebUI.getTextElement(noDataAfterDelete), expectedMessage, "Still not delete yet");
    }

    public String getSuccessMessage() {
        return WebUI.getTextElement(alertSuccess);
    }

    public boolean verifyAllCheckboxIsSelected() {
        List<WebElement> elements = DriverManager.getDriver().findElements(allBinLeadcheckbox);
        int total = elements.size();

        for (int i = 1; i <= total; i++) {
            By indexedCheckbox = By.xpath("(//div[@class='checkbox'])[" + i + "]/input");
            WebElement cb = DriverManager.getDriver().findElement(indexedCheckbox);

            if (!cb.isSelected()) {
                Assert.fail("❌ Checkbox at index " + i + " does not tick!");
            }
        }

        LogUtils.info("✅ All the checkbox ticked.");
        return true;
    }

    public void waitUntilCheckboxSelected(By indexedCheckbox) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));

        wait.until(driver -> {
            WebElement cb = driver.findElement(indexedCheckbox);
            return cb.isSelected();
        });
    }

    public void waitMenuDashboard() {
        WebUI.waitForElementVisible(menuDashboard);
    }

    public void clickSelectAllAndEnsureChecked() {
        int retry = 0;
        int maxRetry = 3;

        while (retry < maxRetry) {

            WebUI.waitForElementVisible(checkboxSelectAllLead);
            WebUI.clickElement(checkboxSelectAllLead);

            List<WebElement> elements = DriverManager.getDriver().findElements(allBinLeadcheckbox);
            int total = elements.size();

            for (int i = 1; i <= total; i++) {
                By indexedCheckbox = By.xpath("(//div[@class='checkbox'])[" + i + "]/input");

                try {
                    waitUntilCheckboxSelected(indexedCheckbox);
                } catch (Exception e) {
                    LogUtils.warn("⏳ Checkbox " + i + " does not tick, retry...");
                }
            }

            if (verifyAllCheckboxIsSelected()) {
                LogUtils.info("✅ All checkbox ticked after retry number: " + retry);
                return;
            }

            LogUtils.warn("⚠️ Not ticked all yet, retry number: " + (retry + 1));
            retry++;
        }
        Assert.fail("❌ After clicked Select All many times but still has checkbox does not tick yet.");
    }

    public void clickButtonBulkActions() {
        WebUI.clickElement(buttonBulkActions);
    }

    public void clickCheckboxMassDelete() {
        WebUI.clickElement(checkboxMassDelete);
    }

    public void clickButtonConfirm() {
        WebUI.clickElement(buttonConfirm);
    }

    public void verifyTooltipContent(String expectedContent) {
        AssertHelper.assertEquals(WebUI.getTextElement(tooltipContent), expectedContent, "Tooltip content incorrect");
    }

    public void clickButtonExport() {
        WebUI.clickElement(buttonExport);
    }

    public void clickButtonEdit() {
        WebUI.clickElement(buttonEdit);
    }

    public void exportFileType(String fileType) {

        switch (fileType.toUpperCase()) {
            case "PDF":
                WebUI.clickElement(optionPDF);
                break;
            case "EXCEL":
                WebUI.clickElement(optionExcel);
                break;
            case "CSV":
                WebUI.clickElement(optionCSV);
                break;
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }

    public String exportFile(ExportFileType type, String expectedFileName) {

        clickButtonExport();
        exportFileType(type.name());

        String filePath = DriverManager.getDownloadPath()
                + File.separator
                + expectedFileName;

        FileHelper.waitForFileExists(filePath, 10);

        return filePath;
    }

    public void exportAndVerifyContentFile(ExportFileType type, String expectedFileName, Map<String, String> uiData) {

        String filePath = exportFile(type, expectedFileName);

        try {

            String fileText;

            switch (type) {
                case PDF:
                    fileText = FileHelper.readPdfText(filePath);
                    break;

                case EXCEL:
                    fileText = FileHelper.readExcelAsText(filePath);
                    break;

                case CSV:
                    fileText = FileHelper.readCsvText(filePath);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported export type: " + type);
            }

            verifyExportContent(normalizeText(fileText), uiData);

        } finally {

            FileHelper.deleteFile(filePath);

        }
    }

    private void verifyExportContent(String fileNorm, Map<String, String> uiData) {

        LogUtils.info("📋 Verify exported data:");

        for (Map.Entry<String, String> entry : uiData.entrySet()) {

            String field = entry.getKey();
            String value = entry.getValue();

            LogUtils.info(field + " : " + value);

            if (value == null || value.trim().isEmpty()) {
                continue;
            }

            AssertHelper.assertTrue(
                    fileNorm.contains(normalizeText(value)),
                    field + " not found in exported file"
            );
        }
    }

    private String normalizeText(String text) {
        if (text == null) return "";
        return text
                .replaceAll("\\s+", " ")
                .replaceAll("[\\u00A0]", " ")
                .trim();
    }

    public void deleteRecordAfterHover() {
        clickButtonDelete();
        WebUI.acceptAlert();
    }

    public void deleteRecordAfterSelectCheckbox() {
        clickButtonBulkActions();
        clickCheckboxMassDelete();
        clickButtonConfirm();
        WebUI.acceptAlert();
    }

    public void deleteRecordAfterSelectDropdown() {
        clickDropdownMore();
        clickButtonDelete();
        WebUI.acceptAlert();
    }

    public String getCurrentTab() {
        return DriverManager.getDriver().getWindowHandle();
    }

    public String switchToNewTab(String currentTab) {

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        for (String handle : DriverManager.getDriver().getWindowHandles()) {
            if (!handle.equals(currentTab)) {
                DriverManager.getDriver().switchTo().window(handle);
                return handle;
            }
        }

        throw new RuntimeException("New tab was not opened.");
    }

    public void switchToCurrentTab(String tabHandle) {
        DriverManager.getDriver().switchTo().window(tabHandle);
    }

    public void clickToGetPageNumber(int size) {
        WebUI.clickElement(getPageNumber(size));
    }

}
