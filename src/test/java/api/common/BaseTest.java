package api.common;

import settings.globals.EndPointGlobal;
import settings.globals.TokenGlobal;
import settings.keywords.ApiKeyword;
import models.api.Login;
import settings.reports.AllureManager;
import settings.utils.LogUtils;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void loginUser() {

        Login loginPOJO = testdata.api.Login.getDataLogin();
        Gson gson = new Gson();

        Response response = ApiKeyword.postNotAuth(EndPointGlobal.EP_LOGIN, gson.toJson(loginPOJO));

        //response.prettyPrint();

        response.then().statusCode(200);

        TokenGlobal.TOKEN = response.getBody().path("token");
        LogUtils.info("Token Global: " + TokenGlobal.TOKEN);
        AllureManager.saveTextLog("Token Global: " + TokenGlobal.TOKEN);
    }
}
