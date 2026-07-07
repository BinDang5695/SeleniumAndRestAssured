package test.ui.testdata;
import models.ui.KnowledgeBase;

public class KnowledgeBaseData {

    public static KnowledgeBase getKnowledgeBase() {
        return new KnowledgeBase(
                "Bin Article",
                "java",
                "Bin article description"
        );
    }

}