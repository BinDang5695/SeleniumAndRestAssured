package ui.testcases;

import io.qameta.allure.*;
import ui.common.BaseTest;
import org.testng.annotations.Test;

    public class DashboardTest extends BaseTest {

        @Epic("Regression Test")
        @Feature("Verify")
        @Story("Dashboard")
        @Owner("Bin Tester dz")
        @Severity(SeverityLevel.CRITICAL)
        @Description("Verify dashboard page after login success")
        @Test(priority = 1)
        public void verifyDashboard()
        {
            dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        }

}
