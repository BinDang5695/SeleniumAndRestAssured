package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import models.ui.KnowledgeBase;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import ui.testdata.KnowledgeBaseData;
import static settings.keywords.WebUI.*;

public class KnowledgeBaseTest extends BaseTest {

    @Epic("Regression Test")
    @Feature("Add New Knowledge Base")
    @Story("Knowledge Base")
    @Owner("Bin Tester")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Jira", url = "https://anhtester.atlassian.net/browse/CRM-11")
    @Issue("CRM-10")
    @Description("Add new Knowledge Base, verify and delete Knowledge Base")
    @Test(priority = 0)
    public void manageKnowledgeBase() {
        KnowledgeBase knowledgeBase = KnowledgeBaseData.getKnowledgeBase();
        dashboardPage().verifyDashboardPage("Invoices Awaiting Payment", "3 / 5");
        clickByMenuName(Menu.KNOWLEDGE_BASE);
        knowledgeBase().clickButtonNewArticle();
        knowledgeBase().addNewArticle(knowledgeBase);
        clickByMenuName(Menu.KNOWLEDGE_BASE);
        knowledgeBase().switchBetweenTabTest(knowledgeBase);
        knowledgeBase().moveToCreatedArticle(knowledgeBase);
        clickButtonDelete();
        acceptAlert();
        clickButtonX();
    }
}
