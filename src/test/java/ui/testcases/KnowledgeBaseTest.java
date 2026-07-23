package ui.testcases;

import constants.CRM.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import ui.common.BaseTest;
import testdata.ui.KnowledgeBase;

@Epic("Regression Test")
@Feature("Knowledge Base")
public class KnowledgeBaseTest extends BaseTest {

    private final models.ui.KnowledgeBase article = KnowledgeBase.getKnowledgeBase();

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Create")
    @Story("Knowledge Base")
    @Description("Create Knowledge Base Article Successfully")
    @Test(priority = 1)
    public void KNOWLEDGE_BASE_001_CreateArticleSuccessfully() {
        basePage().clickByMenuName(Menu.KNOWLEDGE_BASE);
        knowledgeBase().clickButtonNewArticle();
        knowledgeBase().inputToAddNewArticle(article);
        knowledgeBase().clickButtonSave();
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Switch tab")
    @Story("Knowledge Base")
    @Description("Verify user can switch tab to test")
    @Test(priority = 2)
    public void KNOWLEDGE_BASE_002_ViewArticleSuccessfully() {
        String mainTab = basePage().getCurrentTab();
        basePage().clickByMenuName(Menu.KNOWLEDGE_BASE);
        knowledgeBase().moveToCreatedArticle(article);
        knowledgeBase().clickButtonView();
        basePage().switchToNewTab(mainTab);
        knowledgeBase().verifyArticleDetail(article);
        knowledgeBase().voteArticle();
        knowledgeBase().verifyFeedbackMessage(Message.THANKS_FOR_YOUR_FEEDBACK);
        knowledgeBase().waitForRealTime();
        knowledgeBase().voteArticle();
        knowledgeBase().verifyFeedbackMessage(Message.YOU_CAN_VOTE_ONCE_IN_24_HOURS);
    }

    @Owner("Bin Tester dz")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Delete, verify")
    @Story("Knowledge Base")
    @Description("Delete Knowledge Base Article Successfully")
    @Test(priority = 3)
    public void KNOWLEDGE_BASE_004_DeleteArticleSuccessfully() {
        basePage().clickByMenuName(Menu.KNOWLEDGE_BASE);
        knowledgeBase().moveToCreatedArticle(article);
        basePage().deleteRecordAfterHover();
        basePage().verifyNoItems(Message.NO_ENTRIES_FOUND);
    }

}