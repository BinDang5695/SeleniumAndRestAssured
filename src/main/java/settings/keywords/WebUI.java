package settings.keywords;

import settings.drivers.DriverManager;
import settings.helpers.PropertiesHelper;
import settings.reports.AllureManager;
import settings.reports.ExtentTestManager;
import settings.utils.LogUtils;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static settings.drivers.DriverManager.getDriver;

public class WebUI {

    private static int timeout = Integer.parseInt(PropertiesHelper.getValue("EXPLICIT_WAIT"));

    public static WebElement getWebElement(By by) {
        return getDriver().findElement(by);
    }

    @Step("Open URL: {0}")
    public static void openURL(String url) {
        getDriver().get(url);
        WebUI.waitForPageLoaded();
        LogUtils.info("\uD83C\uDF10 Open URL: " + url);
        ExtentTestManager.logMessage(Status.PASS, "Open URL: " + url);
    }

    public static String getCurrentURL() {
        String currentUrl = getDriver().getCurrentUrl();
        LogUtils.info("Current URL: " + currentUrl);
        return currentUrl;
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
            wait.until(expectation);
            LogUtils.info("Page loaded successfully.");
        } catch (Throwable error) {
            LogUtils.info("Page not loaded after waiting for 10 seconds.");
            Assert.fail("Page not loaded after waiting for 10 seconds.");
        }
    }

    public static void waitForPageRefresh(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));

            WebElement oldElement = getDriver().findElement(by);

            getDriver().navigate().refresh();

            wait.until(ExpectedConditions.stalenessOf(oldElement));

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));

            System.out.println("✅ Page is refreshed and element is reloaded successfully.");
        } catch (TimeoutException e) {
            System.out.println("⏳ Timeout waiting for page to refresh: " + by);
        } catch (NoSuchElementException e) {
            System.out.println("❌ Element not found before refresh: " + by);
        }
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.info("❌ Element " + by + " not found after waiting for 10 seconds.");
            Assert.fail("❌ Element " + by + " not found after waiting for 10 seconds.");
        }
    }

    public static void waitForElementVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable error) {
            LogUtils.info("❌ Element " + element + " not found after waiting for 10 seconds.");
            Assert.fail("❌ Element " + element + " not found after waiting for 10 seconds.");
        }
    }

    @Step("Click on element {0}")
    public static void clickElement(By by) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
                WebElement element = wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(by)
                ));
                element.click();

                LogUtils.info("Click element " + by);
                ExtentTestManager.logMessage(Status.PASS, "Click on element " + by);
                AllureManager.saveTextLog("Click on element " + by);
                return;

            } catch (StaleElementReferenceException e) {
                attempts++;
                LogUtils.warn("Retrying click due to stale element. Attempt: " + attempts);
            }
        }
        Assert.fail("❌ Failed to click element after retries: " + by);
    }

    @Step("Click on element {0}")
    public static void clickElement(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
                WebElement clickable = wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(element)
                ));
                clickable.click();

                LogUtils.info("Click element " + element);
                ExtentTestManager.logMessage(Status.PASS, "Click on element " + element);
                AllureManager.saveTextLog("Click on element " + element);
                return;

            } catch (StaleElementReferenceException e) {
                attempts++;
                LogUtils.warn("Retrying click due to stale element. Attempt: " + attempts);
            }
        }
        Assert.fail("❌ Failed to click element after retries: " + element);
    }

    @Step("Set text: {1} on element {0}")
    public static void setTextElement(By by, String text) {
        waitForElementVisible(by);
        clearText(by);
        getDriver().findElement(by).sendKeys(text);
        LogUtils.info("Set text: " + text + " on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Set text: " + text + " on element " + by);
        AllureManager.saveTextLog("==> TEXT " + text);
    }

    @Step("Clear text of element {0}")
    public static void clearText(By by) {
        waitForElementVisible(by);
        getDriver().findElement(by).clear();
        LogUtils.info("Clear text of element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Clear text of element " + by);
        AllureManager.saveTextLog("Clear text of element " + by);
    }

    @Step("Get text of element {0}")
    public static String getTextElement(By by) {
        waitForElementVisible(by);
        String text = getDriver().findElement(by).getText();
        LogUtils.info("Get text of element " + by + ": " + text);
        ExtentTestManager.logMessage(Status.PASS, "Get text of element " + by + ": " + text);
        ExtentTestManager.logMessage(Status.INFO, "==> TEXT " + text);
        AllureManager.saveTextLog("==> TEXT " + text);
        return text;
    }

    @Step("Get text of element {0}")
    public static String getTextElementRetry(By by) {

        int retry = 3;

        while (retry > 0) {

            try {

                waitForElementVisible(by);

                String text = getDriver()
                        .findElement(by)
                        .getText()
                        .trim();

                LogUtils.info("Get text of element " + by + ": " + text);

                ExtentTestManager.logMessage(
                        Status.PASS,
                        "Get text of element " + by + ": " + text
                );

                ExtentTestManager.logMessage(
                        Status.INFO,
                        "==> TEXT " + text
                );

                AllureManager.saveTextLog("==> TEXT " + text);

                return text;

            } catch (StaleElementReferenceException e) {

                retry--;

                LogUtils.warn(
                        "Stale element detected. Retry get text: "
                                + by
                                + " | Remaining retry: "
                                + retry
                );

                sleep(1);
            }
        }

        throw new RuntimeException(
                "Cannot get text because element is stale: " + by
        );
    }

    @Step("Get text of element {0}")
    public static String getTextElement(String locator) {
        By by;

        if (locator.startsWith("//") || locator.startsWith("(//")) {
            by = By.xpath(locator);
        } else {
            by = By.cssSelector(locator);
        }

        return getTextElement(by);
    }

    public static boolean waitForText(By by, String expectedText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        return wait.until(ExpectedConditions.textToBe(by, expectedText));
    }

    @Step("Get attribute: {1} on element {0}")
    public static String getAttributeElement(By by, String attributeName) {
        waitForElementVisible(by);
        String value = getDriver().findElement(by).getAttribute(attributeName);
        LogUtils.info("Get attribute " + attributeName + " of element " + by + ": " + value);
        ExtentTestManager.logMessage(Status.PASS, "Get attribute " + attributeName + " of element " + by + ": " + value);
        ExtentTestManager.logMessage(Status.INFO, "==> ATTRIBUTE " + value);
        AllureManager.saveTextLog("==> ATTRIBUTE " + value);
        return value;
    }

    public static List<WebElement> getWebElements(By by) {
        return getDriver().findElements(by);
    }

    public static Boolean checkElementExist(By by) {
        waitForElementVisible(by);
        List<WebElement> listElement = getWebElements(by);

        if (listElement.size() > 0) {
            LogUtils.info("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            LogUtils.info("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    public static void sendKeysUploadFile(By locator, String filePath) {
        DriverManager.getDriver().findElement(locator).sendKeys(filePath);
    }


    public static void uploadFileWithRobotClass(By element, String filePath) {

        try {

            LogUtils.info("Click upload button");
            WebUI.clickElement(element);

            Thread.sleep(3000);

            LogUtils.info("Copy path: " + filePath);

            StringSelection selection =
                    new StringSelection(filePath);

            Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .setContents(selection, null);
            
            Robot robot = new Robot();

            LogUtils.info("Paste path");

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(2000);

            LogUtils.info("Press ENTER");

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(3000);

            LogUtils.info("Upload finished");

        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static boolean checkElementDisplayed(By by) {
        try {
            waitForElementVisible(by);
            boolean isDisplayed = getDriver().findElement(by).isDisplayed();
            LogUtils.info("Element " + by + " is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (NoSuchElementException e) {
            LogUtils.info("Element " + by + " not found.");
            return false;
        }
    }

    public static boolean checkFieldIsToday(By by, String pattern) {
        try {
            waitForElementVisible(by);
            String uiDate = getDriver().findElement(by).getText().trim();

            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            String todayStr = today.format(formatter);

            LogUtils.info("UI date: " + uiDate + " | Expected today: " + todayStr);

            return uiDate.equals(todayStr);

        } catch (Exception e) {
            LogUtils.error("Error checking field date: " + e.getMessage());
            return false;
        }
    }

    @Step("Move to element {0}")
    public static void moveToElement(By by) {
        sleep(3);
        waitForElementVisible(by);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(by)).perform();
        LogUtils.info("Move to element " + by);
    }

    @Step("Move to element {0}")
    public static void moveToElement(WebElement element) {
        waitForElementVisible(element);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        String info = getElementInfo(element, null);
        LogUtils.info("Move to element " + info);
    }

    public static String getElementInfo(WebElement element, By by) {
        try {
            if (by != null) return by.toString();
            String text = element.getText();
            String id = element.getAttribute("id");
            String cls = element.getAttribute("class");
            String label = element.getAttribute("aria-label");

            String info = element.getTagName();
            if (!text.isEmpty()) info += " text='" + text + "'";
            if (id != null && !id.isEmpty()) info += " id='" + id + "'";
            if (cls != null && !cls.isEmpty()) info += " class='" + cls + "'";
            if (label != null && !label.isEmpty()) info += " aria-label='" + label + "'";

            return info;
        } catch (Exception e) {
            return element.toString();
        }
    }

    @Step("Accepted Alert")
    public static void acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
            LogUtils.info("Alert accepted.");
        } catch (Throwable error) {
            LogUtils.info("No alert found after waiting for 10 seconds.");
            Assert.fail("No alert found after waiting for 10 seconds.");
        }
    }

    @Step("Dismissed Alert")
    public static void dismissAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            alert.dismiss();
            LogUtils.info("Alert dismissed.");
        } catch (Throwable error) {
            LogUtils.info("No alert found after waiting for 10 seconds.");
            Assert.fail("No alert found after waiting for 10 seconds.");
        }
    }

    // Advanced

    @Step("Scroll to element {0}")
    public static void scrollToElement(By by) {
        waitForElementVisible(by);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }

    @Step("Scroll to element {0}")
    public static void scrollToElementTrue(WebElement element) {
        waitForElementVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Scroll element into view if needed {0}")
    public static void scrollIntoViewIfNeeded(By by) {
        waitForElementVisible(by);

        WebElement element = getWebElement(by);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        Boolean isInViewport = (Boolean) js.executeScript(
                """
                var elem = arguments[0];
                var rect = elem.getBoundingClientRect();
    
                return (
                    rect.top >= 0 &&
                    rect.left >= 0 &&
                    rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
                    rect.right <= (window.innerWidth || document.documentElement.clientWidth)
                );
                """,
                element
        );

        if (!Boolean.TRUE.equals(isInViewport)) {
            js.executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                    element
            );
        }

        LogUtils.info("Scroll into view if needed: " + by);
    }

    @Step("Scroll to element {0}")
    public static void scrollToCenterElement(By by) {
        LogUtils.info("🧭 Scrolling to element: " + by);
        waitForElementVisible(by);

        WebElement element = getWebElement(by);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});",
                element
        );

        WebUI.sleep(1);

        waitForElementVisible(element);
    }

    @Step("Scroll to element {0}")
    public static void scrollToElement(WebElement element) {
        LogUtils.info("🧭 Scrolling to element: " + element);
        waitForElementVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});",
                element
        );
        WebUI.sleep(1);
    }


    public static void scrollToElementAtTop(By by) {
        waitForElementVisible(by);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    }

    public static void scrollToElementAtBottom(By by) {
        waitForElementVisible(by);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }

    public static void scrollToTop() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            long lastScroll = (long) js.executeScript("return window.pageYOffset");

            while (true) {

                js.executeScript("window.scrollTo(0, 0);");
                WebUI.sleep(2);

                long newScroll = (long) js.executeScript("return window.pageYOffset");
                if (newScroll == lastScroll) {
                    break;
                }
                lastScroll = newScroll;
            }
        } catch (Exception e) {
            LogUtils.error("⚠️ Error while scrolling to top: " + e.getMessage());
        }
    }

    public static void scrollToBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

            while (true) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                WebUI.sleep(2);

                long newHeight = (long) js.executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (Exception e) {
            LogUtils.error("⚠️ Error while scrolling to bottom: " + e.getMessage());
        }
    }

    public static void scrollHorizontally(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'nearest', inline: 'center'});", element);
    }

    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            LogUtils.info("Dragged and dropped element from " + fromElement + " to " + toElement);
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static void switchToIframe(By iframe) {
        try {
            WebUI.waitForElementVisible(iframe);
            WebElement iframeElement = getWebElement(iframe);
            DriverManager.getDriver().switchTo().frame(iframeElement);
        } catch (Exception e) {
            LogUtils.error("Failed to switch to iframe: " + iframe.toString(), e);
            throw e;
        }
    }

    public static void switchToDefaultContent() {
        try {
            DriverManager.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            LogUtils.error("Failed to switch to default content.", e);
            throw e;
        }
    }

    public static void selectOptionByText(By locator, String text) {

        LogUtils.info("Select option by text: " + text + " on element " + locator);

        try {
            WebElement element = DriverManager.getDriver()
                    .findElement(locator);

            Select select = new Select(element);
            select.selectByVisibleText(text);

            LogUtils.info("Selected option successfully: " + text);

        } catch (Exception e) {
            LogUtils.error("❌ Cannot select option by text: " + text
                    + " on element " + locator);
            throw e;
        }
    }

    public static void selectOptionByValue(By locator, String value) {

        LogUtils.info("Select option by value: " + value + " on element " + locator);

        try {
            WebElement element = DriverManager.getDriver()
                    .findElement(locator);

            Select select = new Select(element);
            select.selectByValue(value);

            LogUtils.info("Selected option successfully: " + value);

        } catch (Exception e) {
            LogUtils.error("❌ Cannot select option by value: " + value
                    + " on element " + locator);
            throw e;
        }
    }
}
