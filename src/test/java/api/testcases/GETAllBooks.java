package api.testcases;

import api.common.BaseTest;
import settings.globals.EndPointGlobal;
import settings.keywords.ApiKeyword;
import settings.utils.LogUtils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GETAllBooks extends BaseTest {

    @Test
    @Severity(SeverityLevel.MINOR)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Book")
    @Description("Read all Books")
    public void testGetBooks(){
        Response response = ApiKeyword.get(EndPointGlobal.EP_BOOKS);
        ApiKeyword.verifyStatusCode(response, 200);
        LogUtils.info(ApiKeyword.getResponseKeyValue(response, "response[0].name"));
    }
}