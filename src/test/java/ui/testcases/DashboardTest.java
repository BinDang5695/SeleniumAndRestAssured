package ui.testcases;

import ui.common.BaseTest;
import org.testng.annotations.Test;

    public class DashboardTest extends BaseTest {

        @Test
        public void verifyDashboard()
        {
            dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        }

}
